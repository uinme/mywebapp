package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.CaseFormat;

import model.Model;
import model.UserModel;

public class UserDAO extends DAO {
  public UserModel find(String email, String encryptedPassword) {
    Connection connection = getConnection();
    UserModel user = null;
    try {
      PreparedStatement statement = connection.prepareStatement(
      "SELECT * FROM user WHERE email = ? AND encrypted_password = ?"
      );
      statement.setString(1, email);
      statement.setString(2, encryptedPassword);
      ResultSet result = statement.executeQuery();

      while(result.next()) {
        user = new UserModel();
        user.setId(result.getInt("id"));
        user.setUsername(result.getString("username"));
        user.setEmail(result.getString("email"));
        user.setEncrypedPassword(result.getString("encrypted_password"));
        user.setCreatedAt(result.getTimestamp("created_at"));
        user.setUpdatedAt(result.getTimestamp("updated_at"));
      }

      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return user;
  }

  public UserModel findByEmail(String email) {
    Connection connection = getConnection();

    UserModel user = null;
    try {
      PreparedStatement statement = connection.prepareStatement(
        "SELECT * FROM user WHERE email = ?"
      );
      statement.setString(1, email);
      ResultSet result = statement.executeQuery();

      while(result.next()) {
        user = new UserModel();
        user.setId(result.getInt("id"));
        user.setUsername(result.getString("username"));
        user.setEmail(result.getString("email"));
        user.setEncrypedPassword(result.getString("encrypted_password"));
        user.setCreatedAt(result.getTimestamp("created_at"));
        user.setUpdatedAt(result.getTimestamp("updated_at"));
      }

      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return user;
  }

  public int createUser(String email, String encryptedPassword, Timestamp createdAt, Timestamp updatedAt) {
    Connection connection = getConnection();

    int line = 0;
    try {
      PreparedStatement statement = connection.prepareStatement(
        "INSERT INTO user VALUES (NULL, NULL, ?, ?, ?, ?)"
      );
      statement.setString(1, email);
      statement.setString(2, encryptedPassword);
      statement.setTimestamp(3, createdAt);
      statement.setTimestamp(4, updatedAt);
      statement.executeUpdate();
      line = statement.executeUpdate();

      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return line;
  }

  public int updateUser(UserModel user) {
    Connection connection = getConnection();

    int line = 0;
    try {
      PreparedStatement statement = connection.prepareStatement(
        "UPDATE user SET username = ?, email = ?, encrypted_password = ?, created_at = ?, updated_at = ? WHERE id = ?"
      );
      statement.setString(1, user.getUsername());
      statement.setString(2, user.getEmail());
      statement.setString(3, user.getEncryptedPassword());
      statement.setTimestamp(4, user.getCreatedAt());
      statement.setTimestamp(5, user.getUpdatedAt());
      statement.setInt(6, user.getId());
      line = statement.executeUpdate();

      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return line;
  }
}
