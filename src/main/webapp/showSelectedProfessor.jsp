<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.IOException,java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.SQLException,dao.ConnectionUtil,jakarta.servlet.RequestDispatcher,jakarta.servlet.ServletConfig,jakarta.servlet.ServletException,jakarta.servlet.http.HttpServlet,jakarta.servlet.http.HttpServletRequest,jakarta.servlet.http.HttpServletResponse,jakarta.servlet.http.HttpSession"%>
<%
	String tid = (String)application.getAttribute("tid");
	if(tid == null || tid.length() == 0) {
		request.setAttribute("msg", "请重新登录！");
		RequestDispatcher dispatcher = request.getRequestDispatcher("relogin.jsp");
		dispatcher.forward(request, response);
	}
	Class.forName("com.mysql.cj.jdbc.Driver");
	String user = "root";
	String password = "123456";
	String url = "jdbc:mysql://127.0.0.1:3306/teacher_management";
	Connection con = DriverManager.getConnection(url, user, password);
	PreparedStatement stmt = con.prepareStatement("SELECT tid FROM teacher WHERE tid=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	stmt.setString(1, tid);
	ResultSet rs = stmt.executeQuery();
	rs.next();
	String str = rs.getString(1);
	if(!rs.getString(1).equals(tid)) {
		request.setAttribute("msg", "请重新登录！");
		RequestDispatcher dispatcher = request.getRequestDispatcher("relogin.jsp");
		dispatcher.forward(request, response);
	}
%>
<link rel="stylesheet" type="text/css" href="style.css" />
<html>
<head>
<jsp:include page="navigator.txt"></jsp:include>
</head>
<body background="image/bkg.png">
	<jsp:useBean id="bean" class="bean.Bean" scope="request" />
	<div class="card">
	<form action="deleteSelectedProfessor" method="get">
		<table class="table">
			<tr>
				<th>请勾选专家
				<%
				String columnName[] = bean.getColumnName();
				for (int i = 0; i < columnName.length; i++) {
					out.print("<th>" + columnName[i]);
				}
				%>
				<%
				String tableRecord[][] = bean.getTableRecord();
				for (int i = 0; i < tableRecord.length; i++) {
					//out.print("<tr>");
					out.print("<tr>");
					String pass = tableRecord[i][0]+tableRecord[i][1]+tableRecord[i][2]+tableRecord[i][4];
					%>
					
					<td><input type="checkbox" name="selected" value="<%=pass %>">
					<%
					for (int j = 0; j < tableRecord[i].length; j++) {
						out.print("<td>" + tableRecord[i][j]);
					}
				}
				%>
		</table>
		<button class="button">删除</button>
	</form>
	</div>
</body>
</html>