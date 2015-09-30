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

		<title>My JSP 'register.jsp' starting page</title>

		<script type="text/javascript">
	function check() {
		var name = document.getElementById("userName").value;
		if (name == "") {
			alert('用户名不能为空！！！！');
			return false;
		}//怎么能跳转刷新该页面？

		for (i = 0; i < name.length; i++) {
			if (!((name != '<') && (name != '>') && (name != '*')
					&& (name != '`') && (name != '~') && (name != '!')
					&& (name != '@') && (name != '#') && (name != '$')
					&& (name != '%') && (name != '^') && (name != '&')
					&& (name != "(") && (name != ")") && (name != "+")
					&& (name != "=") && (name != ',') && (name != '.')
					&& (name != '/') && (name != ';') && (name != ':')
					&& (name != "'") && (name != '"') && (name != '?')
					&& (name != '{') && (name != '}') && (name != '[')
					&& (name != ']') && (name != '|'))) {
				alert("姓名含有非法字符，请修改后再提交.");
				return false;
			}
		}

		var password = document.getElementById("userPassword").value;
		var repassword = document.getElementById("reuserPassword").value;
		if (password == "") {
			alert('密码不能为空~');
			return false;
		}

		if (repassword != password) {
			alert('两次输入不一样，请检查后重新输入');
			return false;
		}

		var comment = document.getElementById("userComment").value;
		var type = document.getElementById("userType").value;
		if (type == "admin" && comment != "111") {
			alert('注册管理员需要输入正确的系统密码，盗号呢吧');
		return false;
			}

		//return true;
		document.form.submit();
	}
</script>

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
		<div style="text-align: center;">
			<div style="font-size: 30px; font-weight: bold">
				用户注册
			</div>
			<form action="UserRegisterServlet" name="register_form" method="post"
				onsubmit="check();return false;">
				<table align="center" border="1">
					<tr>
						<td>
							用户名：
						</td>
						<td>
							<input type="text" name="userName" value="" id="userName" />
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<input type="password" name="userPassword" id="userPassword" />
						</td>
					</tr>
					<tr>
						<td>
							请再输入密码：
						</td>
						<td>
							<input type="password" name="reuserPassword" id="reuserPassword" />
						</td>
					</tr>
					<tr>
						<td>
							性别：
						</td>
						<td>
							<input type="radio" name="userSex" value="nan" checked="checked" />
							男
							<input type="radio" name="userSex" value="nv" />
							女
						</td>
					</tr>
					<tr>
						<td>
							爱好：
						</td>
						<td>
							<input type="checkbox" name="userHobby" value="dushu"
								checked="checked" />
							读书
							<input type="checkbox" name="userHobby" value="kanbao" />
							看报
							<input type="checkbox" name="userHobby" value="lvyou" />
							旅游
						</td>
					</tr>
					<tr>
						<td>
							用户类型：
						</td>
						<td>
							<select name="userType" id="userType">
								<option>
									-------请选择------
								</option>
								<option value="admin">
									用户管理员
								</option>
								<option value="manager">
									经理
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							若您想注册用户管理员，
							</br>
							请回答保密问题：
							</br>
							系统密码是多少
						</td>
						<td>
							<textarea rows="5" cols="30" name="userComment" id="userComment"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							文件上传：
						</td>
						<td>
							<input type="file" name="userFile" />
						</td>
					</tr>
					<tr>
						<td>
							隐藏表单域：
						</td>
						<td>
							r
							<input type="hidden" name="userHide" value="xxx" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="注册" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>

	</body>
</html>
