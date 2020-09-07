package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserModel;

public class UserController extends Controller {

    public UserController(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
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
        
    }

    @Override
    public void editAction() throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void createAction() throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");

        UserDAO dao = new UserDAO();

        UserModel user = dao.findByEmail(email);

        List<String> messages = new ArrayList<>();
        boolean error = false;

        if (email.isEmpty()) {
            messages.add("Eメールアドレスを入力してください");
            error = true;
        }

        if (user != null) {
            messages.add(email + "は既に登録されています");
            error = true;
        }

        if (password.isEmpty()) {
            messages.add("パスワードを入力してください");
            error = true;
        }

        if (passwordConfirmation.isEmpty()) {
            messages.add("確認パスワードを入力してください");
            error = true;
        }

        if (!password.equals(passwordConfirmation)) {
            messages.add("パスワードと確認パスワードが一致しません");
            error = true;
        }

        if (error) {
            request.setAttribute("alert", messages);
            request.setAttribute("yield", "/WEB-INF/jsp/user/new.jsp");
            request.getRequestDispatcher("/WEB-INF/jsp/application.jsp").forward(request, response);
            return;
        }
        
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        dao.createUser(email, password, createdAt, createdAt);

        response.sendRedirect(request.getContextPath() + "/index");
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
