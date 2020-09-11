<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="model.UserModel"%>

<div class="container">
    <h1 class="mb-5">フォロー中のユーザー</h1>
    <% if (request.getAttribute("users") != null) { %>
        <% for (UserModel user : (List<UserModel>) request.getAttribute("users")) { %>
            <% request.setAttribute("userId", user.getId()); %>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/user/show?id=${userId}"><%= user.getUsername() %></a>
            </li>
        </ul>
        <% } %>
    <% } %>
</div>
