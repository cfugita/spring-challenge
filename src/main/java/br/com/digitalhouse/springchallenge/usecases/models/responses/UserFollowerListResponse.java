package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.ArrayList;
import java.util.List;

public class UserFollowerListResponse {
    private Long userId;
    private String userName;
    private List<UserResponse> followers;

    public UserFollowerListResponse(Long userId, String userName, List<UserResponse> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public UserFollowerListResponse() {
        this.followers = new ArrayList<>();
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

    public List<UserResponse> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserResponse> followers) {
        this.followers = followers;
    }
}
