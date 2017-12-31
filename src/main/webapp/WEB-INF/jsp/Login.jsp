<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@ include file="Header.jsp"%>
<!--  jquery core -->
<script src="js/jquery/jquery-1.4.1.min.js" type="text/javascript"></script>

<!-- Custom jquery scripts -->
<script src="js/jquery/custom_jquery.js" type="text/javascript"></script>


</head>
<body>
	<!--  start loginbox ................................................................................. -->
	<div id="loginbox">

		<!--  start login-inner -->
		<form action="doLogin.html" method="POST">
			<div id="login-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>Username</th>
						<td><input type="text" class="login-inp" name="txtUserName" /></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="password" class="login-inp"
							name="txtPassword" /></td>
					</tr>

					<tr>
						<th></th>
						<td><input type="submit" class="submit-login" /></td>
					</tr>
					<tr>
						<th></th>
						<td><span style="color: red">${loginMessage}</span></td>
					</tr>
				</table>
			</div>
		</form>
		<!--  end login-inner -->
		<div class="clear"></div>

	</div>
	<!--  end loginbox -->

</body>
</html>