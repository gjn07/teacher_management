<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>教学质量考核管理系统</title>
<div style="background: #1B4F80;padding: 20px 0;">
<img src="image/logo.png" width="524" height="102" border="0" alt="河南应用技术职业学院" title="河南应用技术职业学院"></img>
</div>
</head>
<body background="image/bkg.png">
<%
	String msg = (String)request.getAttribute("msg");
	if(msg == null) msg = "error!";
%>
<script>
alert("<%=msg %>");
</script>
<link rel="stylesheet" type="text/css" href="login.css"/>
<form action="login" method="post">
<div class="outer_box">
    <div class="login_box">
		<h3 class="title">教师登录</h3>
		<p><i class="iconfont">工号</i><input type="text" required="required" placeholder="用户名" name="tid"></p>
		<p><i class="iconfont">密码</i><input type="password" required="required" placeholder="密码" name="password"></p>
		<button style="margin:30px;margin-left: 100px;width:100px;height:40px;">登录</button>
	</div>
</form>
</body>
</html>