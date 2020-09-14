package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.FollowModel;
import model.UserModel;

public class FollowDAO extends DAO {
    public List<UserModel> findFollowingUsers(int followerUserId) {
        Connection connection = getConnection();
        
        List<UserModel> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT followed.id, followed.username FROM user" +
                "    INNER JOIN follow             ON user.id = follow.follower_user_id" +
                "    INNER JOIN user AS followed   ON follow.followed_user_id = followed.id " +
                "WHERE followed.id != ?"
            );
            statement.setInt(1, followerUserId);
            ResultSet r = statement.executeQuery();

            while (r.next()) {
                UserModel user = new UserModel();
                user.setId(r.getInt("id"));
                user.setUsername(r.getString("username"));
                users.add(user);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public int createFollow(int followerId, int followedId) {
        Connection connection = getConnection();

        int line = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO follow VALUES (NULL, ?, ?)"
            );
            statement.setInt(1, followerId);
            statement.setInt(2, followedId);
            line = statement.executeUpdate();
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return line;
    }

    public FollowModel findByFollowerIdAndFollowedId(int followerId, int followedId) {
        Connection connection = getConnection();

        FollowModel follow = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM follow WHERE follower_user_id = ? AND followed_user_id = ?"
            );
            statement.setInt(1, followerId);
            statement.setInt(2, followedId);
            ResultSet r = statement.executeQuery();

            while (r.next()) {
                follow = new FollowModel();
                follow.setId(r.getInt("id"));
                follow.setFollowerUserId(r.getInt("follower_user_id"));
                follow.setFollowedUserId(r.getInt("followed_user_id"));
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return follow;
    }

    public int deleteFollow(FollowModel follow) {
        Connection connection = getConnection();

        int line = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM follow WHERE id = ?"
            );
            statement.setInt(1, follow.getId());
            line = statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return line;
    }

    public boolean isFollowing(int followerUserId, int followedUserId) {
        FollowModel follow = findByFollowerIdAndFollowedId(followerUserId, followedUserId);
        
        if (follow == null) {
            return false;
        }

        return true;
    }
}
