<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="../css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="log-form">
    <h2>Login to your account</h2>
    <form action="/account" method="post">
        <input type="hidden" name="action" value="login">
        <input type="text" name="email" placeholder="username" />
        <input type="password" name="pwd" placeholder="password" />
        <button type="submit" class="btn">Login</button>
    </form>
</div><!--end log form -->
</body>
</html>