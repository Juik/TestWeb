<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'billshowallbypage_and_mohu.jsp' starting page</title>

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
		<DIV style="font-size: 30px; font-weight: bold; text-align: center;">
			${requestScope.name},您好,欢迎来到订单管理中心
			<br />
			<a style="float: right" href="login.jsp";> MainPage</a>
			<br />
		</DIV>
		<div style="text-align: center;">
			<form action="BillShowAllByPageAndMohuServlet" method="post">
				订单名称：
				<input type="text" name="productName"
					value="${requestScope.productName }" />
				供应商名称：
				<input type="text" name="supplierName"
					value="${requestScope.supplierName }" />
				<input type="submit" value="查询" />
			</form>
			<div style="text-align: center;">
				<a href="addbill.jsp">添加订单请点击这里</a>
				<br />
				<br />
			</div>
			<c:if test="${requestScope.page.totalCount!=0}">
				<div style="font-size: 30px; font-weight: bold; text-align: center;">
					显示所有订单信息
				</div>
				<br />
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
								产品名
							</th>
							<th>
								供应公司
							</th>
							<th>
								数量
							</th>
							<th>
								单价
							</th>
							<th>
								总价
							</th>
							<th>
								订单时间
							</th>
							<th>
								销售员
							</th>
							<th>
								删除
							</th>
							<th>
								修改
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
									${user.bill_id }
								</td>
								<td>
									${user.productName }
								</td>
								<td>
									${user.supplierName }
								</td>
								<td>
									${user.amount }
								</td>
								<td>
									${user.price}
								</td>
								<td>
									${user.pay}
								</td>
								<td>
									${user.billtime }
								</td>
								<td>
									${user.saleworker }
								</td>
								<td>
									<a href="BillDeleteServlet?id=${user.bill_id }">删除</a>
								</td>
								<td>
									<a href="BillFindBillById?id=${user.bill_id }">修改</a>
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
								<form method="post" action="BillShowAllByPageAndMohuServlet">
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
								<form method="post" action="BillShowAllByPageAndMohuServlet">
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
								<form method="post" action="BillShowAllByPageAndMohuServlet">
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
								<form method="post" action="BillShowAllByPageAndMohuServlet">
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
								<form method="post" action="BillShowAllByPageAndMohuServlet">
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
								<form method="post" action="BillShowAllByPageAndMohuServlet">
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
								<form method="post" action="BillShowAllByPageAndMohuServlet">
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
								<form method="post" action="BillShowAllByPageAndMohuServlet">
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
			<c:if test="${requestScope.page.totalCount==0}" >
			<br/><br/><br/><br/><br/>
			<a style="font-size: 83px; font-weight: bold; float:left;">没有符合数据，请换其他条件查询!!</a>
			<br/><br/><br/><br/><br/><br/><br/><br/><br/>
			<a style="font-size: 50px; color:red;font-weight: bold; text-align:center;" href="BillShowAllByPageAndMohuServlet">返回查询首页</a>
			</c:if>
		</div>
	</body>
</html>
