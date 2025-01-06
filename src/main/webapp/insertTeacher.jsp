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
	int a = 0;
	int b = a;
	if(!rs.getString(1).equals(tid)) {
		request.setAttribute("msg", "请重新登录！");
		RequestDispatcher dispatcher = request.getRequestDispatcher("relogin.jsp");
		dispatcher.forward(request, response);
	}
%>
<link rel="stylesheet" type="text/css" href="style.css"/>
<html>
<head>
<jsp:include page="navigator.txt"></jsp:include> 
</head>
<body background="image/bkg.png">
<div class="card" style="font-size:20px;">
<form action="insertTeacher" method="get">
	学年(如2022~2023)：<input type="text" name="year1" value="2022" style="width: 50px;height:25px">
	~<input type="text" name="year2" value="2023" style="width: 50px;height:25px">
	第<select name="term">
        <option value="一">一</option>
        <option value="二">二</option>
    </select>学期
	<br>工号：<input type="text" name="tid" style="width: 50px;height:25px">
	<br>教师姓名：<input type="text" name="tname" style="width: 70px;height:25px">
	<br>教师身份：<input type="text" name="identity" style="width: 70px;height:25px">
	<br>列入考核情况：<select name="status">
        <option value="正常考核">正常考核</option>
        <option value="不予考核">不予考核</option>
    </select>
    <br>部门：<select name="dname">
        <option value="党群部门">党群部门</option>
        <option value="行政部门">行政部门</option>
        <option value="教学部门">教学部门</option>
        <option value="教辅部门" selected>教辅部门</option>
    </select>
    <br>教研室：<select  name="oname">
	<option  value="党委办公室" >党委办公室</option>
	<option  value="纪委">纪委</option>
	<option  value="党委宣传部">党委宣传部</option>
	<option  value="党委学生工作部">党委学生工作部</option>
	<option  value="工会">工会</option>
	<option  value="退休人员工作处">退休人员工作处</option>
	<option  value="团委">团委</option>
	
	<option  value="院长办公室">院长办公室</option>
	<option  value="人事处">人事处</option>
	<option  value="教务处">教务处</option>
	<option  value="发展与质量管理处">发展与质量管理处</option>
	<option  value="财务处">财务处</option>
	<option  value="科研处事处">人事处</option>
	<option  value="招生处">招生处</option>
	<option  value="校企合作与就业处">校企合作与就业处</option>
	<option  value="资产管理处">资产管理处</option>
	<option  value="基建处">基建处</option>
	<option  value="保卫处">保卫处</option>
	<option  value="后勤处">后勤处</option>

	<option  value="化学工程学院">化学工程学院</option>
	<option  value="制药工程学院">制药工程学院</option>
	<option  value="医药学院">医药学院</option>
	<option  value="机电工程学院">机电工程学院</option>
	<option  value="信息工程学院">信息工程学院</option>
	<option  value="护理学院">护理学院</option>
	<option  value="建筑工程学院">建筑工程学院</option>
	<option  value="经济管理学院">经济管理学院</option>
	<option  value="商学院">商学院</option>
	<option  value="本科部">本科部</option>
	<option  value="马克思主义学院">马克思主义学院</option>
	<option  value="基础教学部">基础教学部</option>
	<option  value="体育教学部">体育教学部</option>
	<option  value="马克思主义学院">马克思主义学院</option>
	
	<option  value="信息化管理中心">信息化管理中心</option>
	<option  value="图书馆">图书馆</option>
	<option  value="心理健康教育中心">心理健康教育中心</option>
	<option  value="继续教育学院">继续教育学院</option>
	<option  value="创新创业学院" selected>创新创业学院</option>
	<option  value="职业教育研究所">职业教育研究所</option>
    </select>
	<br>备注（考核或未考核，如未考核，请简单说明)：<textArea name="comment" rows="3" cols="15"></textArea>
	<button>提交</button>
</form>
</div>
</body>
</html>