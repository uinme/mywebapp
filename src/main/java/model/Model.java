package model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

  public List<String> getFieldNames() {
    Class<Model> clazz = (Class<Model>) this.getClass();
    Field fields[] =  clazz.getDeclaredFields();
    List<String> fileldNames = new ArrayList<>();

    for (int i = 0; i < fields.length; i++) {
      fileldNames.add(fields[i].getName());
    }

    return fileldNames;
  }
}
