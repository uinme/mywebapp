<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<div class="container p-5">
    <h1 class="mb-5">${requestScope.user.username}</h1>
    <% if (session.getAttribute("user") != null) { %>
    <a href="#" class="btn btn-primary">フォローする</a>
    <% } %>
</div>
