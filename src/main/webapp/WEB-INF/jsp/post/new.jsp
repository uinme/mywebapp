<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<div class="container">
    <h1 class="md-3">投稿</h1>
    <form action="${pageContext.request.contextPath}/post/create" method="post">
        <div class="form-group row">
            <label for="content" class="col-form-label">内容</label>
            <textarea name="content" id="content" class="form-control" rows="10"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">投稿</button>
    </form>
</div>
