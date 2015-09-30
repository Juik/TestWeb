<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    <script type="text/javascript">
    function check(){
	var name= document.getElementById("userName").value;
	if(name==""){
	alert('用户名不能为空！！！！');
    return false;
	}
	var password = document.getElementById("userPassword").value;
	if(password==""){
	alert('密码不能为空~');
	return false;
	}  
	document.form.submit();
    }
    </script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="text-align:center;">
    	<div style="font-size:30px;font-weight:bold">用户登录</div>
    	<br/>
    	<br/>
    	<form action="UserLoginServlet" name="login_form" method="post" onsubmit="check();">
    	<table align="center" border="2">
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="userName" id="userName"/></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="userPassword" id="userPassword"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="submit" value="登陆" />
    				<input type="reset" value="重置"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<a href="register.jsp" >点击注册</a>
    			</td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
