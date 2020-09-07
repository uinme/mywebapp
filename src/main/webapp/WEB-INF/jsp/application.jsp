<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Basic webapp</title>
  <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"> -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" charset="UTF-8" type="text/css">
</head>
<body>
  <header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a href="index" class="navbar-brand">
        Basic Webapp
      </a>

      <ul class="navbar-nav mr-auto">
        
      </ul>
      
      <ul class="navbar-nav">
        <li class="navbar-item">
          <% if (session.getAttribute("user") != null) { %>
            <a href="${pageContext.request.contextPath}/session/delete" class="btn btn-light">ログアウト</a>
          <% } else { %>
            <a href="#" class="btn btn-success">新規登録</a>
            <a href="${pageContext.request.contextPath}/session/new" class="btn btn-success">ログイン</a>
          <% } %>
        </li>
      </ul>
    </nav>
    
    <% if (request.getAttribute("alert") != null) { %>
      <div class="alert alert-danger" role="alert">
        ${requestScope.alert}
      </div>
      <% request.removeAttribute("alert"); %>
    <% } %>
  </header>

  <jsp:include page="${requestScope.yield}"/>

  <footer>

  </footer>

  <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
