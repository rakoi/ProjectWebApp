<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link  href="/css/bootstrap.css" rel="stylesheet" ></link>
    <link  href="/css/bootstrap-theme.css" rel="stylesheet"></link>
    <link  href="/css/custom.css" rel="stylesheet"></link>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <title>Servlet</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="navbar-header">
        <a class="navbar-brand" href="/admin">ClassEye Admin Panel</a>
    </div>
    <ul class="nav navbar-nav pull-right">
        <li><a href="/admin">Add Lecturer</a></li>
        <li><a href="/admin/assignUnits">Add Lecturer Units</a></li>

        <li>
            <a href=""data-toggle="dropdown">${username} <span class="caret"></span></a></a>
            <ul class="dropdown-menu">
                <li><a href="/logout">Sign<br>out</a></li>

            </ul>
        </li>
    </ul>
</nav>
