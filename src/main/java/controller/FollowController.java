package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FollowDAO;
import model.FollowModel;
import model.UserModel;

public class FollowController extends Controller {

    public FollowController(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        super(context, request, response);
    }

    @Override
    public void indexAction() throws Exception {
        HttpSession session = request.getSession();
        Object object = session.getAttribute("user");

        List<String> messages = new ArrayList<>();
        if (object == null) {
            messages.add("ログインしていません。");
        }

        if (!messages.isEmpty()) {
            alert(messages, "/WEB-INF/jsp/follow/index.jsp");
            return;
        }

        UserModel user = (UserModel) object;
        int userId = user.getId();

        FollowDAO dao = new FollowDAO();
        List<UserModel> followingUsers = dao.findFollowingUsers(userId);

        request.setAttribute("users", followingUsers);
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
        HttpSession session = request.getSession();
        Object object = session.getAttribute("user");

        String followedIdStr = request.getParameter("followed_id");

        List<String> messages = new ArrayList<>();

        if (object == null) {
            messages.add("ログインしてください");
        }

        if (followedIdStr == null || followedIdStr.isEmpty()) {
            messages.add("フォローするIDが指定されていません");
        }

        if (!messages.isEmpty()) {
            alert(messages, "/WEB-INF/jsp/follow/index.jsp");
            return;
        }

        UserModel user = (UserModel) object;
        int followerId = user.getId();
        int followedId = Integer.parseInt(followedIdStr);

        FollowDAO dao = new FollowDAO();
        dao.createFollow(followerId, followedId);

        response.sendRedirect(request.getContextPath() + "/follow/index");
    }

    @Override
    public void updateAction() throws Exception {

    }

    @Override
    public void deleteAction() throws Exception {
        HttpSession session = request.getSession();
        Object object = session.getAttribute("user");
        int deletingUserId = Integer.parseInt(request.getParameter("followed_id"));

        List<String> messages = new ArrayList<>();
        if (object == null) {
            messages.add("ログインしてください");
        }

        if (!messages.isEmpty()) {
            alert(messages, "/WEB-INF/jsp/index/index.jsp");
            return;
        }

        UserModel currentUser = (UserModel) object;
        int currentUserId = currentUser.getId();

        FollowDAO dao = new FollowDAO();

        FollowModel follow = dao.findByFollowerIdAndFollowedId(currentUserId, deletingUserId);

        dao.deleteFollow(follow);

        response.sendRedirect(request.getContextPath() + "/user/show?id=" + deletingUserId);
    }
    
}
