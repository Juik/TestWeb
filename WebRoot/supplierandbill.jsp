<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>Manage my supplier list or bill list</title>

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
		<div style="font-size: 30px; font-weight: bold; text-align: center;"> 
			请选择管理供应商或者订单？ 
		</div>
		<br />
		<br />
		<br />
		<br />
		<form method="post" action="SupplierShowAllByPageAndMohuServlet" align="center">
		<input type="submit" name="supplierButton" value="供应商" />
		</form>
		<br/><br/><br/><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<form method="post" action="BillShowAllByPageAndMohuServlet" align="center" >
		<input type="submit" name="billButton" value="订单"/>
		</form>
	</body>
</html>
