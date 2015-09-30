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
    <div >
    	<div style="font-size:30px;font-weight:bold">显示所有用户信息</div>
    	<table  border="1">
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
    	<div style="float:left;">
				总记录数：${requestScope.page.totalCount }
		</div>
				<div style="float:left;">
				<c:if test="${requestScope.page.totalPage != 1}">
					<!-- 首页显示的跳转连接 -->
					<c:if test="${requestScope.page.currentPage == 1}">
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageServlet">
								第[1/${requestScope.page.totalPage }]页&nbsp;
								<input type="hidden" name="currentPage"
									value="${requestScope.page.nextPage}" />
								
								<input type="submit" name="submit" value="下一页" />
							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageServlet">
								<input type="hidden" name="currentPage"
									value="${requestScope.page.totalPage }" />
								<input type="submit" name="submit" value="最后一页" />
							</form>
						</div>
					</c:if>

					<!-- 末页显示的跳转连接 -->
					<c:if
						test="${requestScope.page.currentPage == requestScope.page.totalPage}">
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageServlet">
								第[${requestScope.page.totalPage }/${requestScope.page.totalPage
								}]页&nbsp;
								<input type="hidden" name="currentPage" value="1" />
								<input type="submit" name="submit" value="首页" />

							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageServlet">
								<input type="hidden" name="currentPage"
									value="${requestScope.page.previousPage}" />
								<input type="submit" name="submit" value="上一页" />

							</form>
						</div>
					</c:if>
					<!-- 中间页显示的跳转连接 -->
					<c:if
						test="${requestScope.page.currentPage < requestScope.page.totalPage && requestScope.page.currentPage > 1}">
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageServlet">
								第[${requestScope.page.currentPage}/${requestScope.page.totalPage
								}]页&nbsp;&nbsp;
								<input type="hidden" name="currentPage" value="1" />
								<input type="submit" name="submit" value="首页" />

							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageServlet">
								&nbsp;&nbsp;
								<input type="hidden" name="currentPage"
									value="${requestScope.page.previousPage}" />
								<input type="submit" name="submit" value="上一页" />

							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageServlet">
								&nbsp;&nbsp;
								<input type="hidden" name="currentPage"
									value="${requestScope.page.nextPage}" />
								<input type="submit" name="submit" value="下一页" />
							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageServlet">
								&nbsp;&nbsp;
								<input type="hidden" name="currentPage"
									value="${requestScope.page.totalPage}" />
								<input type="submit" name="submit" value="末页" />

							</form>
						</div>
					</c:if>
				</c:if>
			</div>
    </div>
  </body>
</html>
