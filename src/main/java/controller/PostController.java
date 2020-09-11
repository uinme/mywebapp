package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostDAO;
import model.PostModel;
import model.UserModel;

public class PostController extends Controller {

  public PostController(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
    super(context, request, response);
  }

  @Override
  public void indexAction() throws Exception {
    PostDAO dao = new PostDAO();

    List<PostModel> posts = dao.all();

    request.setAttribute("posts", posts);
  }

  @Override
  public void showAction() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void newAction() throws Exception {
    
  }

  @Override
  public void editAction() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void createAction() throws Exception {
    HttpSession session = request.getSession();
    Object object = session.getAttribute("user");

    List<String> messages = new ArrayList<>();
    
    if (object == null) {
      messages.add("ログインしてください");
    }

    String content = request.getParameter("content");
    if (content == null || content.isEmpty()) {
      messages.add("ツイート内容を入力してください");
    }

    if (!messages.isEmpty()) {
      alert(messages, "/WEB-INF/jsp/post/new.jsp");
      return;
    }

    UserModel user = (UserModel) object;
    PostModel post = new PostModel();

    post.setUserId(user.getId());
    post.setContent(content);
    post.setCreatedAt(new Timestamp(System.currentTimeMillis()));
    post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

    PostDAO dao = new PostDAO();
    dao.createPost(post);

    response.sendRedirect(request.getContextPath() + "/post/index");
  }

  @Override
  public void updateAction() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAction() throws Exception {
    // TODO Auto-generated method stub

  }
  
}
