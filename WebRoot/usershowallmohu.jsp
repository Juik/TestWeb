<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usershowall.jsp' starting page</title>
    
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
    	<form action="UserShowAllByMohuServlet" method="post">
    		用户名：<input type="text" name="userName" value="${requestScope.userName }"/>
    		密码：<input type="text" name="userPassword" value="${requestScope.userPassword }"/>
    		<input type="submit" value="查询" />
    	</form>
    	<div style="font-size:30px;font-weight:bold">显示所有用户信息</div>
    	<table align="center" border="1">
    		<tr>
    			<th>序号1</th>
    			<th>序号2</th>
    			<th>id</th>
    			<th>用户名</th>
    			<th>密码</th>
    			<th>删除</th>
    			<th>修改</th>
    		</tr>
    		<c:forEach var="user" items="${requestScope.mohudata}" varStatus="vs">
    		<tr>
    			<td>${vs.index }</td>
    			<td>${vs.count }</td>
    			<td>${user.id }</td>
    			<td>${user.userName }</td>
    			<td>${user.userPassword }</td>
    			<td><a href="UserDeleteServlet?id=${user.id }">删除</a></td>
    			<td><a href="UserFindUserById?id=${user.id }">修改</a></td>
    		</tr>
    		</c:forEach>
    	</table>
    </div>
  </body>
</html>
