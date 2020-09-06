package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Model implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public Connection getConnection() throws SQLException, NamingException {
    InitialContext context = new InitialContext();
    DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/basic_webapp");
    Connection connection = dataSource.getConnection();
    
    return connection;
  }  
}
