<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'suppliershowallbypage_and_mohu.jsp' starting
			page</title>

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
		<%
			String s = session.getId(); //获取session ID号
		%>
		<p>
			你的session对象ID是：
		</p>
		<%=s%>
		<%!int Num = 0; //定义前面要加!号

		synchronized void countPeople() { //同步方法
		Num++;
		System.out.println("You are Num:"+Num);
	}%>
		<%
				countPeople();
				String str = String.valueOf(Num);
				session.setAttribute("count", str); //将str 添加到session对象中
		%>
		<p>
			你是第
			<%=(String) session.getAttribute("count")%>
			个访问本站的人
		</p>
		<!--将session对象的count值取出-->


		<DIV style="font-size: 30px; font-weight: bold; text-align: center;">
			${requestScope.name},您好,欢迎来到供应商管理中心
			<br />
			<a style="float: right" href="login.jsp";> MainPage</a>
			<br />
		</DIV>
		<div style="text-align: center;">
			<form action="SupplierShowAllByPageAndMohuServlet" method="post">
				供应商姓名：
				<input type="text" name="productName"
					value="${requestScope.productName }" />
				联系人姓名：
				<input type="text" name="supplierName"
					value="${requestScope.supplierName }" />
				<input type="submit" value="查询" />
			</form>
			<div style="text-align: center;">
				<a href="addsupplier.jsp">添加供应商请点击这里</a>
				<br />
				<br />
			</div>
			<c:if test="${requestScope.page.currentPageData!=null}">
				<div style="font-size: 30px; font-weight: bold; text-align: center;">
					显示所有供应商信息
				</div>
				<br />
				<div style="text-align: center;">
					<table align="center" border="1">
						<tr>
							<th>
								序号1
							</th>
							<th>
								序号2
							</th>
							<th>
								id
							</th>
							<th>
								供应商姓名
							</th>
							<th>
								联系人
							</th>
							<th>
								电话
							</th>
							<th>
								地址
							</th>
						</tr>
						<c:forEach var="user" items="${requestScope.page.currentPageData}"
							varStatus="vs">
							<tr>
								<td>
									${vs.index }
								</td>
								<td>
									${vs.count }
								</td>
								<td>
									${user.sup_id }
								</td>
								<td>
									${user.supplierName }
								</td>
								<td>
									${user.contactman }
								</td>
								<td>
									${user.phone }
								</td>
								<td>
									${user.address}
								</td>
								<td>
									<a href="SupplierDeleteServlet?id=${user.sup_id }">删除</a>
								</td>
								<td>
									<a href="SupplierFindSupplierById?id=${user.sup_id }">修改</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<br />
				<br />
				<div style="float: left;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					总记录数：${requestScope.page.totalCount }
				</div>
				<div style="float: left;">
					<c:if test="${requestScope.page.totalPage != 1}">
						<!-- 首页显示的跳转连接 -->
						<c:if test="${requestScope.page.currentPage == 1}">
							<div style="float: left;">
								<form method="post" action="SupplierShowAllByPageAndMohuServlet">
									&nbsp;第[1/${requestScope.page.totalPage }]页&nbsp;
									<input type="hidden" name="currentPage"
										value="${requestScope.page.nextPage}" />

									<input type="hidden" name="productName"
										value="${requestScope.page.keyWords[0]}" />
									<input type="hidden" name="supplierName"
										value="${requestScope.page.keyWords[1]}" />

									<input type="submit" name="submit" value="下一页" />
								</form>
							</div>
							<div style="float: left;">
								<form method="post" action="SupplierShowAllByPageAndMohuServlet">
									<input type="hidden" name="currentPage"
										value="${requestScope.page.totalPage }" />
									<input type="hidden" name="productName"
										value="${requestScope.page.keyWords[0]}" />
									<input type="hidden" name="supplierName"
										value="${requestScope.page.keyWords[1]}" />
									<input type="submit" name="submit" value="最后一页" />
								</form>
							</div>
						</c:if>

						<!-- 末页显示的跳转连接 -->
						<c:if
							test="${requestScope.page.currentPage == requestScope.page.totalPage}">
							<div style="float: left;">
								<form method="post" action="SupplierShowAllByPageAndMohuServlet">
									&nbsp;第[${requestScope.page.totalPage
									}/${requestScope.page.totalPage }]页&nbsp;
									<input type="hidden" name="currentPage" value="1" />

									<input type="hidden" name="productName"
										value="${requestScope.page.keyWords[0]}" />
									<input type="hidden" name="supplierName"
										value="${requestScope.page.keyWords[1]}" />

									<input type="submit" name="submit" value="首页" />

								</form>
							</div>
							<div style="float: left;">
								<form method="post" action="SupplierShowAllByPageAndMohuServlet">
									<input type="hidden" name="currentPage"
										value="${requestScope.page.previousPage}" />

									<input type="hidden" name="productName"
										value="${requestScope.page.keyWords[0]}" />
									<input type="hidden" name="supplierName"
										value="${requestScope.page.keyWords[1]}" />


									<input type="submit" name="submit" value="上一页" />

								</form>
							</div>
						</c:if>
						<!-- 中间页显示的跳转连接 -->
						<c:if
							test="${requestScope.page.currentPage < requestScope.page.totalPage && requestScope.page.currentPage > 1}">
							<div style="float: left;">
								<form method="post" action="SupplierShowAllByPageAndMohuServlet">
									&nbsp;第[${requestScope.page.currentPage}/${requestScope.page.totalPage
									}]页&nbsp;&nbsp;
									<input type="hidden" name="currentPage" value="1" />

									<input type="hidden" name="productName"
										value="${requestScope.page.keyWords[0]}" />
									<input type="hidden" name="supplierName"
										value="${requestScope.page.keyWords[1]}" />

									<input type="submit" name="submit" value="首页" />

								</form>
							</div>
							<div style="float: left;">
								<form method="post" action="SupplierShowAllByPageAndMohuServlet">
									&nbsp;&nbsp;
									<input type="hidden" name="currentPage"
										value="${requestScope.page.previousPage}" />

									<input type="hidden" name="productName"
										value="${requestScope.page.keyWords[0]}" />
									<input type="hidden" name="supplierName"
										value="${requestScope.page.keyWords[1]}" />

									<input type="submit" name="submit" value="上一页" />

								</form>
							</div>
							<div style="float: left;">
								<form method="post" action="SupplierShowAllByPageAndMohuServlet">
									&nbsp;&nbsp;
									<input type="hidden" name="currentPage"
										value="${requestScope.page.nextPage}" />

									<input type="hidden" name="productName"
										value="${requestScope.page.keyWords[0]}" />
									<input type="hidden" name="supplierName"
										value="${requestScope.page.keyWords[1]}" />

									<input type="submit" name="submit" value="下一页" />
								</form>
							</div>
							<div style="float: left;">
								<form method="post" action="SupplierShowAllByPageAndMohuServlet">
									&nbsp;&nbsp;
									<input type="hidden" name="currentPage"
										value="${requestScope.page.totalPage}" />

									<input type="hidden" name="productName"
										value="${requestScope.page.keyWords[0]}" />
									<input type="hidden" name="supplierName"
										value="${requestScope.page.keyWords[1]}" />

									<input type="submit" name="submit" value="末页" />

								</form>
							</div>
						</c:if>
					</c:if>
				</div>
			</c:if>
			<c:if test="${requestScope.page.totalCount==0}">
				<br />
				<br />
				<br />
				<a style="font-size: 83px; font-weight: bold; float: left;">没有符合数据，请换其他条件查询!!</a>
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<a
					style="font-size: 50px; color: red; font-weight: bold; text-align: center;"
					href="BillShowAllByPageAndMohuServlet">返回查询首页</a>
			</c:if>
		</div>
	</body>
</html>
