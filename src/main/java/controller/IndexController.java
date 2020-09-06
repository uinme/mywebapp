package controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends Controller {
  
  public IndexController(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
    super(context, request, response);
  }

  @Override
  public void indexAction() throws Exception {
    
  }

  @Override
  public void showAction() throws Exception {

  }

  @Override
  public void newAction() throws Exception {
 
  }
  
  @Override
  public void editAction() throws Exception {

  }

  @Override
  public void createAction() throws Exception {

  }

  @Override
  public void updateAction() {

  }

  @Override
  public void deleteAction() {

  }
}
