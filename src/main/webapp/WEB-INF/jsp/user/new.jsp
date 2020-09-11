<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<div class="container">
    <h1>新規登録</h1>
    <form action="${pageContext.request.contextPath}/user/create" method="post">
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

        <div class="form-group row">
          <label for="password" class="col-sm-2 col-form-label">Password</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" name="password" placeholder="Password">
          </div>
        </div>

        <div class="form-group row">
            <label for="passwordConfirmation" class="col-sm-2 col-form-label">Password Confirmation</label>
            <div class="col-sm-10">
              <input type="password" class="form-control" name="passwordConfirmation" placeholder="Password Confirmation">
            </div>
        </div>
        
        <div class="form-group row">
          <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">登録</button>
          </div>
        </div>
      </form>
</div>
