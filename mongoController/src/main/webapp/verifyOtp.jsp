<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Verify OTP</title>
</head>
<body>
	<h1>Enter OTP sent to your email</h1>
	<h3>We have sent an OTP to your registered email id</h3>
	<div class="container">
	<form action="/verifyOtp" method="post">
	<h1 style="background-color: orange; color: red;">${error}</h1>
	<input required="required" type="text" name="OTP" placeholder="Enter OTP">
	<button type="submit">verify</button>
	</form>
	</div>
</body>
</html>