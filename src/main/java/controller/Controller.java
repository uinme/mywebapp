package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller {
  protected ServletContext context;
  protected HttpServletRequest request;
  protected HttpServletResponse response;

  public Controller(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
    this.context = context;
    this.request = request;
    this.response = response;
  }

  public abstract void indexAction() throws Exception;
  public abstract void showAction() throws Exception;
  public abstract void newAction() throws Exception;
  public abstract void editAction() throws Exception;
  public abstract void createAction() throws Exception;
  public abstract void updateAction() throws Exception;
  public abstract void deleteAction() throws Exception;

  protected void alert(List<String> messages, String yieldPath) throws ServletException, IOException {
    request.setAttribute("alert", messages);
    request.setAttribute("yield", yieldPath);
    request.getRequestDispatcher("/WEB-INF/jsp/application.jsp").forward(request, response);
  }
}
