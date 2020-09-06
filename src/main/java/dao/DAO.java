package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
  protected Connection getConnection() {
    Connection connection = null;
    try {
      InitialContext context = new InitialContext();
      DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/basic_webapp");
      connection = dataSource.getConnection();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return connection;
  }
}
