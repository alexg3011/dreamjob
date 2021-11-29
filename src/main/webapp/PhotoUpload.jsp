<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Upload</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<h2 align="center"><c:out value="Привет, ${user.name}"/></h2>
<table class="table">
    <thead>
    <tr>
        <th>Добавление фото:</th>
    </tr>
    </thead>
    <tbody>
    <tr valign="top">
        <td>
            <img src="<c:url value='/download?id=${candidate.id}'/>" width="100px" height="100px"/>
        </td>
    </tr>
    </tbody>
</table>
<form action="<c:url value='/upload?id=${candidate.id}'/>" method="post" enctype="multipart/form-data">
    <div class="checkbox">
        <input type="file" name="file">
    </div>
    <button type="submit" class="btn btn-default">Загрузить</button>
</form>
<ul class="nav">
    <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">На главную</a>
    </li>
</ul>
</body>
</html>