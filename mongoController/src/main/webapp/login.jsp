<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<body>
    <div class="container">
        <div class="formContainer signIn">
        	${SPRING_SECURITY_LAST_EXCEPTION.message}
            <form action="/log" method="post">
                <h1>Sign In</h1>
                <input type="text" name="username" placeholder="Username">
                <input type="password" name="password" placeholder="password">
                <a href="/forgotPassword">Forgot Your password?</a>
                <button class="ghost">Login</button>
            </form>
        </div>
        <div class="overlayContainer">
            <div class="overlay">
                <div class="panel overlayRight">
                <form action="/signUp">
                    <h1>Start Your Journey With us</h1>
                    <button>Sign Up</button></form>
                </div>
            </div>
        </div>
    </div>
</body>
<footer>
    <h2>Wipro Limited</h2>
</footer>
</body>
</html>