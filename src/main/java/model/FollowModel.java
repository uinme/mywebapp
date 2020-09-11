package model;

public class FollowModel extends Model {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int followerUserId;
    private int followedUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollowingUserId() {
        return followerUserId;
    }

    public void setFollowingUserId(int followingUserId) {
        this.followerUserId = followingUserId;
    }

    public int getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowerdUserId(int followedUserId) {
        this.followedUserId = followedUserId;
    }

}
