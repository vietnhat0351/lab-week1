<%@ page import="com.example.labweek2.entities.Account" %>
<%@ page import="com.example.labweek2.entities.Role" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: vietn
  Date: 17/09/2023
  Time: 10:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="../css/admin-page.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    Map<Account, Role> map = (Map<Account, Role>) request.getAttribute("accountRole");
%>
<h1 style="align-self: center">ADMIN PAGE</h1>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalAddAccount">
    Thêm Account
</button>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalDeleteAccount">
    Delete Account
</button>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalGrantRole">
    Grant Role
</button>
<div class="container">
    <div class="table">
        <div class="table-header">
            <div class="header__item"><a id="name" class="filter__link" href="#">ID</a></div>
            <div class="header__item"><a id="wins" class="filter__link filter__link--number" href="#">FULL NAME</a></div>
            <div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">EMAIL</a></div>
            <div class="header__item"><a id="losses" class="filter__link filter__link--number" href="#">PHONE</a></div>
            <div class="header__item"><a id="role" class="filter__link filter__link--number" href="#">ROLE</a></div>
            <div class="header__item"><a id="total" class="filter__link filter__link--number" href="#">STATUS</a></div>
        </div>
        <div class="table-content">
            <%
                for (Map.Entry<Account, Role> me : map.entrySet()) { %>
                <div class="table-row">
                    <div class="table-data"><%=me.getKey().getAccountId()%></div>
                    <div class="table-data"><%=me.getKey().getFullName()%></div>
                    <div class="table-data"><%=me.getKey().getEmail()%></div>
                    <div class="table-data"><%=me.getKey().getPhone()%></div>
                    <div class="table-data"><%=me.getValue().getRoleName()%></div>
                    <div class="table-data"><%=me.getKey().getStatus()%></div>
                </div>
            <%}%>
        </div>
    </div>
</div>

<div class="modal fade" id="modalAddAccount">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Form</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form action="/account" method="post">
                    <input type="hidden" value="addaccount" name="action">
                    <input type="text" placeholder="Full name" name="fullName"> <br>
                    <input type="text" placeholder="Email" name="email"> <br>
                    <input type="text" placeholder="Password" name="pwd"> <br>
                    <input type="text" placeholder="Phone" name="phone"> <br>
                    <input type="radio" name="role" id="adminRole" value="admin">
                    <label for="adminRole">Admin</label> <br>
                    <input type="radio" name="role" id="userRole" value="user">
                    <label for="userRole">User</label> <br>
                    <button type="submit">Thêm Account</button>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalDeleteAccount">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Form</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form action="/account" method="post">
                    <input type="hidden" value="deleteaccount" name="action">
                    <input type="text" placeholder="ID Account" name="accountId"> <br>
                    <button type="submit">Delete</button>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalGrantRole">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Form</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form action="/account" method="post">
                    <input type="hidden" value="grantrole" name="action">
                    <input type="text" placeholder="ID Account" name="accountId"> <br>
                    <input type="radio" name="role" id="adminRole1" value="admin">
                    <label for="adminRole1">Admin</label> <br>
                    <input type="radio" name="role" id="userRole1" value="user">
                    <label for="userRole1">User</label> <br>
                    <button type="submit">Submit</button>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
