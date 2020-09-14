<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="model.UserModel"%>

<div class="container p-5">
    <h1 class="mb-5">${requestScope.user.username}</h1>
    <% if (session.getAttribute("user") != null) { %>
        <% UserModel follower = (UserModel) session.getAttribute("user"); %>
        <% UserModel followed = (UserModel) request.getAttribute("user"); %>
        <% if (follower.getId() != followed.getId()) { %>
            <form action="${pageContext.request.contextPath}/follow/create" name="form" method="post">
                <input type="hidden" name="followed_id" value="${requestScope.user.id}">
                <button type="submit" class="btn btn-primary">フォローする</button>
            </form>
        <% } %>
    <% } %>
</div>
