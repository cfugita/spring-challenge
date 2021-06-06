package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.ArrayList;
import java.util.List;

public class UserFollowingListResponse {
    private Long userId;
    private String userName;
    private List<UserResponse> following;

    public UserFollowingListResponse(Long userId, String userName, List<UserResponse> following) {
        this.userId = userId;
        this.userName = userName;
        this.following = following;
    }

    public UserFollowingListResponse() {
        this.following = new ArrayList<>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserResponse> getFollowing() {
        return following;
    }

    public void setFollowing(List<UserResponse> following) {
        this.following = following;
    }
}
