<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/screen.css" type="text/css"
	media="screen" title="default" />
<!--  jquery core -->
<script src="js/jquery/jquery-1.4.1.min.js" type="text/javascript"></script>

<!-- Custom jquery scripts -->
<script src="js/jquery/custom_jquery.js" type="text/javascript"></script>

<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
<script src="js/jquery/jquery.pngFix.pack.js" type="text/javascript"></script>
<script type="text/javascript">
	 $(document).ready(function(){
	 $(document).pngFix( );
	 });
</script>
</head>
<body id="login-bg">

	<!-- Start: login-holder -->
	<div id="login-holder" style="padding-top: 200px;">

		<!-- start logo -->
		<div>
			<a href="index.html"><img src="images/logo.png" width="229"
				height="74" alt="" /></a>
		</div>
		<!-- end logo -->

		<div class="clear"></div>

		<!--  start loginbox ................................................................................. -->
		<div id="loginbox">

			<!--  start login-inner -->
			<form action="doLogin.html" method ="POST" >
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

		<!--  start forgotbox ................................................................................... -->
		<div id="forgotbox">
			<div id="forgotbox-text">Please send us your email and we'll
				reset your password.</div>
			<!--  start forgot-inner -->
			<div id="forgot-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>Email address:</th>
						<td><input type="text" value="" class="login-inp" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" class="submit-login" /></td>
					</tr>
				</table>
			</div>
			<!--  end forgot-inner -->
			<div class="clear"></div>
			<a href="" class="back-login">Back to login</a>
		</div>
		<!--  end forgotbox -->

	</div>
	<!-- End: login-holder -->
</body>
</html>