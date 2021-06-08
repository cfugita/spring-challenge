package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.List;

public class UserInfoResponse {
    private Long userId;
    private String userName;
    private Boolean isSeller;
    private List<Long> following;

    public UserInfoResponse(Long userId, String userName, Boolean isSeller, List<Long> following) {
        this.userId = userId;
        this.userName = userName;
        this.isSeller = isSeller;
        this.following = following;
    }

    public UserInfoResponse() {
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

    public Boolean getSeller() {
        return isSeller;
    }

    public void setSeller(Boolean seller) {
        isSeller = seller;
    }

    public List<Long> getFollowing() {
        return following;
    }

    public void setFollowing(List<Long> following) {
        this.following = following;
    }
}
