package model;

import lombok.Getter;
import lombok.Setter;

public class FollowModel extends Model {
    private static final long serialVersionUID = 1L;
    
    @Getter @Setter private int id;
    @Getter @Setter private int followerUserId;
    @Getter @Setter private int followedUserId;

}
