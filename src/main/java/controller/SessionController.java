package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.UserModel;

public class SessionController extends Controller {

  public SessionController(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
    super(context, request, response);
  }

  @Override
  public void indexAction() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void showAction() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void newAction() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void editAction() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void createAction() throws Exception {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    UserModel user = null;

    UserDAO dao = new UserDAO();
    user = dao.find(email, password);

    if (user != null) {
      HttpSession session = request.getSession();
      session.setAttribute("user", user);
      response.sendRedirect(request.getContextPath() + "/index");
    } else {
      request.setAttribute("alert", "ユーザー名またはパスワードが間違っています。");
      request.setAttribute("yield", "/WEB-INF/jsp/session/new.jsp");
      request.getRequestDispatcher("/WEB-INF/jsp/application.jsp").forward(request, response);
    }
  }

  @Override
  public void updateAction() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteAction() throws Exception {
    HttpSession session = request.getSession();
    session.removeAttribute("user");
    response.sendRedirect(request.getContextPath() + "/index");
  }
  
}
