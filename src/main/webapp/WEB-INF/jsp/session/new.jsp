<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>

<div class="container">
  <h1>ログイン</h1>
  <form action="${pageContext.request.contextPath}/session/create" method="post">
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" name="email" class="form-control">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" name="password" class="form-control">
    </div>
    <button type="submit" class="btn btn-primary">ログイン</button>
  </form>
</div>
