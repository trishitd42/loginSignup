<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
	<form action="/changePassword" method="post">
	<h2>${error}</h2>
	<h2>${success}</h2>
	<h1>Change your Password</h1>
	<input type="password" name="newPass" placeholder="Enter new password">
	<button type="submit" style="background: lightgreen; border: 2px solid lightgreen;">Submit</button> <br>
	<button type="reset">Reset</button>
	</form>
	</div>
</body>
</html>