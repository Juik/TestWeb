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
    	<div style="font-size:30px;font-weight:bold">添加用户信息</div>
    	<br/>
    	<br/>
    	<form action="UserAddServlet" name="add_form" method="post">
    	<table align="center" border="1">
    		<tr>
    			<td>用户名：</td>
    			<td>
    			<input type="text" name="userName" /></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="userPassword"}"/></td>
    		</tr>
    		<tr>
    			<td>选择权限</td>
    			<td>
	    			<input type="radio" name="authority" value="admin">admin
	    			<input type="radio" name="authority" value="manager">manager
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="submit" value="提交" onclick="alert('添加成功')"/>
    				<input type="reset" value="重置"/>
    			</td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
