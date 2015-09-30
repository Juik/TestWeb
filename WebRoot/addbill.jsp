<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addbill.jsp' starting page</title>
    
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
    	<div style="font-size:30px;font-weight:bold">添加订单信息</div>
    	<br/>
    	<br/>
    	<form action="BillAddServlet" name="add_form" method="post" >
    	<table align="center" border="1">
    		<tr>
    			<td>产品名称：</td>
    			<td><input type="text" name="productName" /></td>
    		</tr>
    		<tr>
    			<td>数量：</td>
    			<td><input type="text" name="amount"}"/></td>
    		</tr>
    		<tr>
    			<td>单价：</td>
    			<td><input type="text" name="price"}"/></td>
    		</tr>
    		<tr>
    			<td>总计：</td>
    			<td><input type="text" name="pay"}"/></td>
    		</tr>
    		<tr>
    			<td>供应商名称：</td>
    			<td><input type="text" name="supplierName"}"/></td>
    		</tr>
    		<tr>
    			<td>订单日期(YYYY-MM-DD)：</td>
    			<td><input type="text" name="billtime"}"/></td>
    		</tr>
    		<tr>
    			<td>订销售人员：</td>
    			<td><input type="text" name="saleworker"}"/></td>
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
