package model;

import java.sql.Date;

public class UserModel extends Model {
  private static final long serialVersionUID = 1L;
  
  private int id;
  private String username;
  private String email;
  private String encryptedPassword;
  private Date createdAt;
  private Date updatedAt;

  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEncryptedPassword() {
    return encryptedPassword;
  }

  public void setEncrypedPassword(String encrypedPassword) {
    this.encryptedPassword = encrypedPassword;
  } 

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
