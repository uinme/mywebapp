<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="model.PostModel"%>

<div class="container">
  <% for (PostModel post : (List<PostModel>)request.getAttribute("posts")) { %>
    <div class="card mx-auto mb-3" style="width: 36rem;">
        <div class="card-body">
          <h5 class="card-title">
            <% request.setAttribute("user", post.getUser()); %>
            <a href="${pageContext.request.contextPath}/user/show?id=${requestScope.user.id}">
              ${requestScope.user.username}
            </a>
          </h5>
          <h6 class="card-subtitle mb-2 text-muted"><%= post.getCreatedAt().toString() %></h6>
          <p class="card-text"><%= post.getContent() %></p>
        </div>
    </div>
  <% } %>
</div>
