package model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

public class PostModel extends Model {
  private static final long serialVersionUID = 1L;
  
  @Getter @Setter private int id;
  @Getter @Setter private int userId;
  @Getter @Setter private String content;
  @Getter @Setter private Timestamp createdAt;
  @Getter @Setter private Timestamp updatedAt;
  @Getter @Setter private UserModel user;

}
