package model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class UserModel extends Model {
  private static final long serialVersionUID = 1L;
  
  @Getter @Setter private int id;
  @Getter @Setter private String username;
  @Getter @Setter private String email;
  @Getter @Setter private String encryptedPassword;
  @Getter @Setter private Timestamp createdAt;
  @Getter @Setter private Timestamp updatedAt;

}
