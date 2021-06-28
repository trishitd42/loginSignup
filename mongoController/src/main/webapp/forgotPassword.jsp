<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Forgot Passowrd</title>

</head>
<body>
	<h1>Forgot your Password?</h1>
	<h3>Don't worry, Enter Your registered email, we will send you an one time password</h3>
	<div class="container">
	<form action="/sendOtp" method="post">
	<input required="required" type="email" name="email" placeholder="Enter Email">
	<button type="submit">Send</button>
	</form>
	</div>
</body>
</html>