package model;

import java.sql.Timestamp;

import annotation.SQLColumn;

public class UserModel extends Model {
  private static final long serialVersionUID = 1L;
  
  private @SQLColumn int id;
  private @SQLColumn String username;
  private @SQLColumn String email;
  private @SQLColumn String encryptedPassword;
  private @SQLColumn Timestamp createdAt;
  private @SQLColumn Timestamp updatedAt;

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

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}
