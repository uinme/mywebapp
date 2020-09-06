package controller;

import javax.servlet.ServletContext;
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
}
