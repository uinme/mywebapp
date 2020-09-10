<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<div class="container">
    <h1>ユーザー情報編集</h1>

    <form action="${pageContext.request.contextPath}/user/update" method="post">
        <div class="form-group row">
            <label for="username" class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" name="username" placeholder="Username">
            </div>
        </div>

        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
              <input type="email" class="form-control" name="email" placeholder="Email">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">適用</button>
    </form>
</div>
