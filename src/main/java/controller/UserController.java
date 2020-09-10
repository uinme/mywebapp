package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.UserModel;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        HttpSession session = request.getSession();
        
        if (session.getAttribute("user") == null) {
            List<String> messages = new ArrayList<>();
            messages.add("ログインしてください");
            alert(messages, "/WEB-INF/jsp/session/new.jsp");
            return;
        }
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
            alert(messages, "/WEB-INF/jsp/user/new.jsp");
            return;
        }
        
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        dao.createUser(email, createHash(password), createdAt, createdAt);

        response.sendRedirect(request.getContextPath() + "/index");
    }

    @Override
    public void updateAction() throws Exception {
        HttpSession session = request.getSession();
        UserModel user = (UserModel) session.getAttribute("user");

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        List<String> messages = new ArrayList<>();

        if (username == null && email == null) {
            if (username.isEmpty() && username.isEmpty()) {
                messages.add("変更する項目がありません");
                alert(messages, "/WEB-INF/jsp/user/edit.jsp");
                return;
            }
        }

        if (username != null) {
            if (!username.isEmpty()) {
                user.setUsername(username);
            }
        }

        if (email != null) {
            if (!email.isEmpty()) {
                user.setEmail(email);
            }
        }
        
        UserDAO dao = new UserDAO();
        dao.updateUser(user);

        response.sendRedirect(request.getContextPath() + "/index");
    }

    @Override
    public void deleteAction() throws Exception {
        // TODO Auto-generated method stub

    }
    
    private String createHash(String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode(password);
    }

    private boolean authenticate(String password, String encryptedPassword) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.matches(password, encryptedPassword);
    }
}
