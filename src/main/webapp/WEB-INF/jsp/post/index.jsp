<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="model.PostModel"%>

<div class="container py-4">
    <% for (PostModel post : (List<PostModel>)request.getAttribute("posts")) { %>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
          <h5 class="card-title"><%= post.getUser().getUsername() %></h5>
          <h6 class="card-subtitle mb-2 text-muted"><%= post.getCreatedAt().toString() %></h6>
          <p class="card-text"><%= post.getContent() %></p>
          <a href="#" class="card-link">Card link</a>
          <a href="#" class="card-link">Another link</a>
        </div>
    </div>
    <% } %>
</div>