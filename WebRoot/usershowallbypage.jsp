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
    		<c:forEach var="user" items="${requestScope.page.currentPageData}" varStatus="vs">
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
    	<c:if test="${requestScope.page.totalPage>1}">
    		<c:if test="${requestScope.page.currentPage==1}">
    			<a href="UserShowAllByPageServlet?currentPage=2">下一页</a>
    			<a href="UserShowAllByPageServlet?currentPage=${requestScope.page.totalPage}">尾页</a>
    		</c:if>
    		<c:if test="${requestScope.page.currentPage>1 && requestScope.page.currentPage<requestScope.page.totalPage}">
    			<a href="UserShowAllByPageServlet?currentPage=1">首页</a>
    			<a href="UserShowAllByPageServlet?currentPage=${requestScope.page.previousPage}">上一页</a>
    			<a href="UserShowAllByPageServlet?currentPage=${requestScope.page.nextPage}">下一页</a>
    			<a href="UserShowAllByPageServlet?currentPage=${requestScope.page.totalPage}">尾页</a>
    		</c:if>
    		<c:if test="${requestScope.page.currentPage==requestScope.page.totalPage}">
    			<a href="UserShowAllByPageServlet?currentPage=1">首页</a>
    			<a href="UserShowAllByPageServlet?currentPage=${requestScope.page.previousPage}">上一页</a>
    		</c:if>
    	</c:if>
    </div>
  </body>
</html>
