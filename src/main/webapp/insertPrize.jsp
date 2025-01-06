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
		<form action="insertPrize" method="get">
		<input type="hidden" name="tid" value="<%=tid %>">
			<center>教师获奖申报</center>
			<p>提交类型<select name="type">
        			<option value="教学类技能比赛">教学类技能比赛</option>
        			<option value="教学成果创建方面">教学成果创建方面</option>
    			</select>
			<table class="table">
				<br>比赛名称：<input type="text" name="pname" required="required" style="height:30px;">
				<br>比赛级别<select name="level">
						<option value="省级">省级</option>
						<option value="国家级">国家级</option>
						<option value="世界级">世界级</option>
						
        				
					</select>
				<br>奖项类型<select name="rank">
						<option value="一等奖">一等奖</option>
						<option value="二等奖">二等奖</option>
						<option value="三等奖">三等奖</option>
					</select>
				<br>证明材料:
				<p><textArea name="comment" rows="20" cols="85"></textArea>
			<button>提交审核</button>
		</form>
	</div>
</body>
</html>