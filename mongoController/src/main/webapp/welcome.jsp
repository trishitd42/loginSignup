<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Welcome!</title>
</head>
<body>
 <h1>Welcome User</h1>
 <h2 style="background-color: coral;">Your user id is ${username}</h2>
 <form action="/findUser" method="get">
 <h1>Find User by UserId</h1>
 <input type="text" name="username" placeholder="Enter Your Username">
 <button>Submit</button>
 </form>
 <br> <br>
 <form action="/deleteUser">
 	<h1>Delete Your Account</h1>
 	<input type="text" name="username" placeholder="Enter Username to Delete">
 	<button>Submit</button>
 </form>
 <br> <br>
 <form action="/logout">
	<button>Log Out from your account</button> 
 </form>
</body>
</html>