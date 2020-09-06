package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    ServletContext context = getServletContext();
    String servletPath = request.getServletPath().substring(1);
    String controllerName = controllerName(request);
    String className = "controller." + controllerName;
    String pathInfo = request.getPathInfo();
    String action = null;

    if (pathInfo != null) {
      action = pathInfo.toLowerCase().replace("/", "");
    }

    System.out.println();

    try {
      Controller controller = (Controller)Class.forName(className)
      .getDeclaredConstructor(ServletContext.class, HttpServletRequest.class, HttpServletResponse.class)
      .newInstance(context, request, response);

      if (action == null || action.isEmpty()) {
        action = "index";
      }

      switch (action) {
        case "index":
          controller.indexAction();
          break;
        case "show":
          controller.showAction();
          break;
        case "new":
          controller.newAction();
          break;
        case "edit":
          break;
        case "create":
          controller.createAction();
          break;
        case "update":
          controller.updateAction();
        case "delete":
          controller.deleteAction();
        default:
          response.setStatus(HttpServletResponse.SC_NOT_FOUND);
          return;
      }

      // createおよびupdate,deleteはPOSTリクエストで受けて、DBに書き込みを行うためのアクション
      // のため、jspにフォワードしない。
      if (action.equals("index") || action.equals("show") || action.equals("new")) {
        String jspPath = "/WEB-INF/jsp/" + servletPath + "/" + action + ".jsp";

        // 該当するアクションのjspファイルがない場合、404を返す。
        // (6つのアクションの内、使用しないものはjspを作成しないため)
        if (!new File(context.getRealPath(jspPath)).exists()) {
          response.setStatus(HttpServletResponse.SC_NOT_FOUND);
          return;
        }

        request.setAttribute("yield", jspPath);
        request.getRequestDispatcher("/WEB-INF/jsp/application.jsp").forward(request, response);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    doPost(request, response);
  }

  private String controllerName(HttpServletRequest request) {
    String servletPath = request.getServletPath();
    String servletName = servletPath.substring(1);
    String controllerName = servletName.substring(0, 1).toUpperCase() +
                            servletName.substring(1).toLowerCase() +
                            "Controller";
    
    return controllerName;
  }
}
