<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="formContainer signIn">
            <form action="/addUser" method="post">
                <h1>Start Your Journey With Us</h1>
                <input type="text" name="username" placeholder=" Enter Username">
                <input type="email" name="email" placeholder="Enter Email">
                <input type="password" name="password" placeholder="Enter Password">
                <a href="">Forgot Your password?</a>
                <button class="ghost">SignUp</button>
            </form>
        </div>
        <div class="overlayContainer">
            <div class="overlay">
                <div class="panel overlayRight">
                	<form action="/login">
                    <h1>Already A user?</h1>
                    <button>Login</button></form>
                </div>
            </div>
        </div>
    </div>
</body>
<footer>
    <h2>Wipro Limited</h2>
</footer>
</html>