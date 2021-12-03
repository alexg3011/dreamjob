<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.dream.model.Post" %>
<%@ page import="ru.job4j.dream.store.DbStore" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script>function validate() {
        if ($('#name').val() === '') {
            alert('Введите название вакансии');
            return false;
        }
        if ($('#description').val() === '') {
            alert('Введите описание вакансии');
            return false;
        }
        return true;
    }</script>

    <title>Работа мечты</title>
</head>
<body>
<h2 align="center"><c:out value="Привет, ${user.name}"/></h2>
<%@page contentType="text/html; charset=UTF-8" %>
<%
    String id = request.getParameter("id");
    String description = request.getParameter("description");
    Post post = new Post(0, description);
    if (id != null) {
        post = DbStore.instOf().findPostById(Integer.valueOf(id));
    }
%>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (id == null) { %>
                Новая вакансия.
                <% } else { %>
                Редактирование вакансии.
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/posts.do?id=<%=post.getId()%>" method="post">
                    <div class="form-group">
                        <label>Название</label>
                        <input type="text" class="form-control" name="name" id="name"
                               placeholder="Введите название" <%if (post.getName()==null) { %>
                               placeholder="Введите описание"<% } else { %> value="<%=post.getName()%>" <%}%>>
                    </div>
                    <div class="form-group">
                        <label>Описание</label>
                        <input type="text" class="form-control" name="description" id="description"
                            <%if (post.getDescription()==null) { %> placeholder="Введите описание"<% } else { %>
                               value="<%=post.getDescription()%>" <%}%>>
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="validate();">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">На главную</a>
        </li>
    </ul>
</div>
</body>
</html>