<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>

		<base href="<%=basePath%>">
    
    <title>My JSP 'usershowallbypage_and_mohu.jsp' starting page</title>
    
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
  	<DIV style="font-size:30px;font-weight:bold;text-align:center;">  
  	${requestScope.name},您好,欢迎来到用户管理中心<br/>
  	<a style="float:left" href="login.jsp";>
	首页</a>
	<br/>
  	</DIV>
    <div style="text-align:center;">
    	<form action="UserShowAllByPageAndMohuServlet" method="post">
    		用户名：<input type="text" name="userName" value="${requestScope.userName }"/>
    		密码：<input type="text" name="userPassword" value="${requestScope.userPassword }"/>
    		<input type="submit" value="查询" />
    	</form>
    	</div>
    	<div style="text-align:center;">
    	<a href="adduser.jsp">添加用户请点击这里</a>
    	<br/>
    	<br/>
    	</div>
    	<c:if test="${requestScope.page.currentPageData!=null}">
    	<div style="font-size:30px;font-weight:bold;text-align:center;">显示所有用户信息</div>
    	<br/>
    	<div style="text-align:center;">
    	<table align="center" border="1">
    		<tr>
    			<th>序号1</th>
    			<th>序号2</th>
    			<th>id</th>
    			<th>用户名</th>
    			<th>密码</th>
    			<th>权限</th>
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
    			<td>${user.authority} </td>
    			<td><a href="UserDeleteServlet?id=${user.id }">删除</a></td>
    			<td><a href="UserFindUserById?id=${user.id }">修改</a></td>
    		</tr>
    		</c:forEach>
    	</table>
    	</div>
    	<br/>
    	<br/>
    	<div style="float:left;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				总记录数：${requestScope.page.totalCount }
		</div>
				<div style="float:left;">
				<c:if test="${requestScope.page.totalPage != 1}">
					<!-- 首页显示的跳转连接 -->
					<c:if test="${requestScope.page.currentPage == 1}">
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageAndMohuServlet">
								&nbsp;第[1/${requestScope.page.totalPage }]页&nbsp;
								<input type="hidden" name="currentPage"	value="${requestScope.page.nextPage}" />
								
								<input type="hidden" name="userName" value="${requestScope.page.keyWords[0]}" />
								<input type="hidden" name="userPassword" value="${requestScope.page.keyWords[1]}" />	
								
								<input type="submit" name="submit" value="下一页" />
							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageAndMohuServlet">
								<input type="hidden" name="currentPage"
									value="${requestScope.page.totalPage }" />
								<input type="hidden" name="userName" value="${requestScope.page.keyWords[0]}" />
								<input type="hidden" name="userPassword" value="${requestScope.page.keyWords[1]}" />	
								<input type="submit" name="submit" value="最后一页" />
							</form>
						</div>
					</c:if>

					<!-- 末页显示的跳转连接 -->
					<c:if
						test="${requestScope.page.currentPage == requestScope.page.totalPage}">
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageAndMohuServlet">
								&nbsp;第[${requestScope.page.totalPage }/${requestScope.page.totalPage
								}]页&nbsp;
								<input type="hidden" name="currentPage" value="1" />
								
								<input type="hidden" name="userName" value="${requestScope.page.keyWords[0]}" />
								<input type="hidden" name="userPassword" value="${requestScope.page.keyWords[1]}" />	
								
								<input type="submit" name="submit" value="首页" />

							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageAndMohuServlet">
								<input type="hidden" name="currentPage"
									value="${requestScope.page.previousPage}" />
								
								<input type="hidden" name="userName" value="${requestScope.page.keyWords[0]}" />
								<input type="hidden" name="userPassword" value="${requestScope.page.keyWords[1]}" />	
								
								
								<input type="submit" name="submit" value="上一页" />

							</form>
						</div>
					</c:if>
					<!-- 中间页显示的跳转连接 -->
					<c:if
						test="${requestScope.page.currentPage < requestScope.page.totalPage && requestScope.page.currentPage > 1}">
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageAndMohuServlet">
								&nbsp;第[${requestScope.page.currentPage}/${requestScope.page.totalPage
								}]页&nbsp;&nbsp;
								<input type="hidden" name="currentPage" value="1" />
								
								<input type="hidden" name="userName" value="${requestScope.page.keyWords[0]}" />
								<input type="hidden" name="userPassword" value="${requestScope.page.keyWords[1]}" />	
								
								<input type="submit" name="submit" value="首页" />

							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageAndMohuServlet">
								&nbsp;&nbsp;
								<input type="hidden" name="currentPage"
									value="${requestScope.page.previousPage}" />
								
								<input type="hidden" name="userName" value="${requestScope.page.keyWords[0]}" />
								<input type="hidden" name="userPassword" value="${requestScope.page.keyWords[1]}" />	
									
								<input type="submit" name="submit" value="上一页" />

							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageAndMohuServlet">
								&nbsp;&nbsp;
								<input type="hidden" name="currentPage"
									value="${requestScope.page.nextPage}" />
								
								<input type="hidden" name="userName" value="${requestScope.page.keyWords[0]}" />
								<input type="hidden" name="userPassword" value="${requestScope.page.keyWords[1]}" />	
								
								<input type="submit" name="submit" value="下一页" />
							</form>
						</div>
						<div style="float: left;">
							<form method="post" action="UserShowAllByPageAndMohuServlet">
								&nbsp;&nbsp;
								<input type="hidden" name="currentPage"
									value="${requestScope.page.totalPage}" />
								
								<input type="hidden" name="userName" value="${requestScope.page.keyWords[0]}" />
								<input type="hidden" name="userPassword" value="${requestScope.page.keyWords[1]}" />	
								
								<input type="submit" name="submit" value="末页" />

							</form>
						</div>
					</c:if>
				</c:if>
			</div>
			</c:if>
			<c:if test="${requestScope.page.currentPageData==null}">
			没有符合数据，请换其他条件查询！！
			</c:if>
    </div>
    
  
   <div id="bodyDiv">
		<div id="header">
			<jsp:include page="/branch/header.jsp"/>
		</div>
		<div id="content">
			<fieldset><legend>下载列表</legend>
				<ul>
				<%
					List<String> downloadList=(List<String>)request.getAttribute("downloadList");	
					
					if(downloadList!=null){
						for(String str:downloadList){	
						//这下面这个是啥意思？里面不是已经加了str了么？
						//整个的servlet在哪儿？
							out.print("<li><a href='DownloadFile?file="+str+"'>"+str+"</a></li>");
						}
					}
				%>
				</ul>
			</fieldset>
		
			<!-- enctype属性为表单定义了MIME编码方式，上传文件的表单enctype属性必须如此设置 -->
			<form method="post" action="UploadFileServlet" name="upload_form" enctype="multipart/form-data" >
			<p><input type="text" name="fileIntro" value="" />文件介绍</p>
			<p><input type="file" name="myfile1" /></p>
			<p><input type="submit" value="上传"/></p>
			</form>
		</div>
		<div id="footer">
			<jsp:include page="/branch/footer.jsp"/>
		</div>
	</div>
  </body>
</html>
