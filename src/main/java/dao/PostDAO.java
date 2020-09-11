package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.PostModel;
import model.UserModel;

public class PostDAO extends DAO {
  public int createPost(PostModel post) {
    Connection connection = getConnection();

    int line = 0;
    try {
      PreparedStatement statement = connection.prepareStatement(
        "INSERT INTO post VALUES (NULL, user_id = ?, content = ?, created_at = ?, updated_at = ?)"
      );
      statement.setInt(1, post.getId());
      statement.setString(2, post.getContent());
      statement.setTimestamp(3, post.getCreatedAt());
      statement.setTimestamp(4, post.getUpdatedAt());
      line = statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return line;
  }

  public List<PostModel> all() {
    Connection connection = getConnection();

    List<PostModel> posts = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
        "SELECT " +
        "  tweet.id, tweet.content, tweet.created_at, tweet.updated_at, " +
        "  user.id as user_id, user.username " +
        "FROM tweet " +
        "INNER JOIN user ON tweet.user_id = user.id"
      );
      ResultSet r = statement.executeQuery();

      while (r.next()) {
        PostModel post = new PostModel();
        post.setId(r.getInt("id"));
        post.setUserId(r.getInt("user_id"));
        post.setContent(r.getString("content"));
        post.setCreatedAt(r.getTimestamp("created_at"));
        post.setUpdatedAt(r.getTimestamp("updated_at"));

        UserModel user = new UserModel();
        user.setId(r.getInt("user_id"));
        user.setUsername(r.getString("username"));

        post.setUser(user);
        posts.add(post);
      }

      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return posts;
  }
}
