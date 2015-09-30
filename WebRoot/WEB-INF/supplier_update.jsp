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
    	<div style="font-size:30px;font-weight:bold">供应商修改</div>
    	<form action="SupplierUpdateServlet" name="update_form" method="post">
    	<table align="center" border="1">
    		<tr>
    			<td>供应商姓名：</td>
    			<td>
    			<input type="hidden" name="id" value="${requestScope.updateBill.bill_id }"/>
    			<input type="text" name="supplierName" value="${requestScope.updateSupplier.supplierName }" /></td>
    		</tr>
    		<tr>
    			<td>联系人姓名：</td>
    			<td><input type="text" name="contactman" value="${requestScope.updateSupplier.contactman }"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="submit" value="修改"/>
    				<input type="reset" value="重置"/>
    			</td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
