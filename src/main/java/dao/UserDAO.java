package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        user.setEncrypedPassword(result.getString("encrypted_password"));
        user.setCreatedAt(result.getDate("created_at"));
        user.setUpdatedAt(result.getDate("updated_at"));
      }

      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return user;
  }
}
