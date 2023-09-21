<%@ page import="com.example.labweek2.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: vietn
  Date: 18/09/2023
  Time: 12:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/admin-page.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1 style="align-self: center">USER PAGE</h1>
<div class="container">
    <% Account account = (Account) request.getAttribute("account");%>

    <div class="table">
        <div class="table-header">
            <div class="header__item"><a id="name" class="filter__link" href="#">ID</a></div>
            <div class="header__item"><a id="wins" class="filter__link filter__link--number" href="#">FULL NAME</a></div>
            <div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">EMAIL</a></div>
            <div class="header__item"><a id="losses" class="filter__link filter__link--number" href="#">PHONE</a></div>
            <div class="header__item"><a id="total" class="filter__link filter__link--number" href="#">STATUS</a></div>
        </div>
        <div class="table-content">
            <div class="table-row">
                <div class="table-data"><%=account.getAccountId()%></div>
                <div class="table-data"><%=account.getFullName()%></div>
                <div class="table-data"><%=account.getEmail()%></div>
                <div class="table-data"><%=account.getPhone()%></div>
                <div class="table-data"><%=account.getStatus()%></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
