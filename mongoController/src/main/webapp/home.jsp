<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Welcome User</title>
</head>
<body>
<h3>Welcome User</h3>
 <a href="/findUserdetails">See your user account Information</a>
 <br>
 <form action="/fetchByEmail" method="get">
 <h3>Find User by Email</h3>
 <input type="text" name="email" placeholder="Enter Your email">
 <button>Submit</button>
 </form>
 <br>
 <form action="/deleteUser">
 	<h3>Delete Your Account</h3>
 	<input type="text" name="username" placeholder="Enter Username to Delete">
 	<button>Submit</button>
 </form>
 <a href="/sendMail">click to send verification mail</a>
 <a href="/changemyPassword" style="color: coral;, font-size: 20px;"> Change Password</a>
 <form action="/logout">
	<button>Log Out from your account</button> <br>
 </form>
 <footer>Wipro Limited</footer>
</body>
</html>