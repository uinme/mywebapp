package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.PostModel;

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
}
