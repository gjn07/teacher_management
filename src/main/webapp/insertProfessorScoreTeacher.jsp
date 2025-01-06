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
	<div class="card">
		<form action="insertProfessorScoreTeacher" method="get">
			<center>教师听课记录表</center>
			<table class="table">
			<input type="hidden" name="professor" value="<%=tid %>">
			<input type="hidden" name="ttid" value="<%=request.getParameter("ttid") %>">
				<tr>
					<td>教师工号</td>
					<td><input type="text" name="tid" value="<%=request.getParameter("ttid") %>" class="input" required="required" disabled="disabled"></td>
					<td>科目</td>
					<td><input type="text" name="cname" class="input" required="required"></td>
				</tr>
				<tr>
					<td>地点</td>
					<td><input type="text" name="address" class="input"></td>
					<td>听课时间</td>
					<td><input type="text" name="time" class="input"></td>
				</tr>
			</table>
			
			<table class="table">
				<tr>
					<th>听课内容</th>
				</tr>
				<tr>
					<td><textArea name="content" rows="20" cols="85"></textArea></td>
				</tr>
			</table>
			
			<table class="table">
				<tr>
					<td>评分(按百分制评价)</td>
					<td><input type="text" name="result" class="input" required="required"></td>
				</tr>
			</table>
			<button>提交</button>
		</form>
	</div>
</body>
</html>