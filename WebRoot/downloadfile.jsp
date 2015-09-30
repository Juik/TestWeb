<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>从服务器下载文件</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" />
</head>

<body>
	<div id="bodyDiv">
		<div id="header">
			<jsp:include page="branch/header.jsp"/>
		</div>
		<div id="sidebar">
			<jsp:include page="/branch/sidebar.jsp"/>
		</div>
		<div id="content">
			<a href="DownloadCSVFile">CSV文件下载</a>
		</div>
		<div id="footer">
			<jsp:include page="/branch/footer.jsp"/>
		</div>
	</div>
</body>
</html>