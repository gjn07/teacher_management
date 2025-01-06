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
		<form action="insertScore" method="get">
			<table class="table">
				<tr>
					<td>请输入教师工号</td>
					<td><input type="text" name="tid" placeholder="0000" class="input" required="required"></td>
				</tr>
			</table>
			
			<table class="table">
				<tr>
					<th>师德师风(20)</th>
					<th>政治理论学习考核(10)</th>
					<th>工作作风及廉政表现考核(10)</th>
				</tr>
				<tr>
					<td>请输入相应分数</td>
					<td><input type="text" name="s11" placeholder="0~10" class="input"></td>
					<td><input type="text" name="s12" placeholder="0~10" class="input"></td>
				</tr>
			</table>
			
			<table class="table">
				<tr>
					<th>教学质量(45)</th>
					<th>学生评教(15)</th>
					<th>专家评教(15)</th>
					<th>教学常规检查日常(10)</th>
					<th>课程思政(5)</th>
				</tr>
				<tr>
					<td>请输入相应分数</td>
					<td><input type="text" name="s21" placeholder="0~15" class="input"></td>
					<td><input type="text" name="s22" placeholder="0~15" class="input"></td>
					<td><input type="text" name="s23" placeholder="0~10" class="input"></td>
					<td><input type="text" name="s24" placeholder="0~5" class="input"></td>
				</tr>
			</table>
			
			<table class="table">
				<tr>
					<th>院(部)评价(25)</th>
					<th>学风建设(5)</th>
					<th>院(部)工作(10)</th>
					<th>同行评价(5)</th>
					<th>教师个人专业发展(5)</th>
				</tr>
				<tr>
					<td>请输入相应分数</td>
					<td><input type="text" name="s31" placeholder="0~5" class="input"></td>
					<td><input type="text" name="s32" placeholder="0~10" class="input"></td>
					<td><input type="text" name="s33" placeholder="0~5" class="input"></td>
					<td><input type="text" name="s34" placeholder="0~5" class="input"></td>
				</tr>
			</table>
			
			<table class="table">
				<tr>
					<th>社会服务、实践教学能力(10)</th>
					<th>打分</th>
				</tr>
				<tr>
					<td>请输入相应分数</td>
					<td><input type="text" name="s41" placeholder="0~10" class="input"></td>
				</tr>
			</table>
			
			<table class="table">
				<tr>
					<th>其他扣分项和加分项</th>
					<th>教学事故处罚</th>
					<th>安全事故处理</th>
					<th>教师参加教学类技能比赛</th>
					<th>教学成果创建方面</th>
				</tr>
				<tr>
					<td>请输入相应分数</td>
					<td><input type="text" name="s51" placeholder="扣分0~100" class="input"></td>
					<td><input type="text" name="s52" placeholder="扣分0~10" class="input"></td>
					<td><input type="text" name="s53" placeholder="0~12" class="input"></td>
					<td><input type="text" name="s54" placeholder="0~14" class="input"></td>
				</tr>
			</table>
			<button>提交</button>
		</form>
	</div>
</body>
</html>