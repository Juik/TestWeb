<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bill_update.jsp' starting page</title>
    
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
    	<div style="font-size:30px;font-weight:bold">订单修改</div>
    	<form action="BillUpdateServlet" name="update_form" method="post">
    	<table align="center" border="1">
    		<tr>
    			<td>订单名称：</td>
    			<td>
    			<input type="hidden" name="id" value="${requestScope.updateBill.bill_id }"/>
    			<input type="text" name="productName" value="${requestScope.updateBill.productName }" /></td>
    		</tr>
    		<tr>
    			<td>供应商名称：</td>
    			<td><input type="text" name="supplierName" value="${requestScope.updateBill.supplierName }"/></td>
    		</tr>
    		<tr>
    			<td>数量：</td>
    			<td><input type="text" name="amount" value="${requestScope.updateBill.amount }"/></td>
    		</tr>
    		<tr>
    			<td>单价：</td>
    			<td><input type="text" name="price" value="${requestScope.updateBill.price }"/></td>
    		</tr>
    		<tr>
    			<td>总价：</td>
    			<td><input type="text" name="pay" value="${requestScope.updateBill.pay }"/></td>
    		</tr>
    		<tr>
    			<td>订单日期：</td>
    			<td><input type="text" name="billtime" value="${requestScope.updateBill.billtime }"/></td>
    		</tr>
    		<tr>
    			<td>销售人员：</td>
    			<td><input type="text" name="saleworker" value="${requestScope.updateBill.saleworker }"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="submit" value="修改" onclick="alert('修改成功')"/>
    				<input type="reset" value="重置"/>
    			</td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
