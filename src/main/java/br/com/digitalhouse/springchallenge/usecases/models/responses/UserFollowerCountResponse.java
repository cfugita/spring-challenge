package br.com.digitalhouse.springchallenge.usecases.models.responses;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserFollowerCountResponse {
    private Long userId;
    private String userName;
    private Integer followerCount;

    public UserFollowerCountResponse(Long userId, String userName, Integer followerCount) {
        this.userId = userId;
        this.userName = userName;
        this.followerCount = followerCount;
    }

    public UserFollowerCountResponse() {
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

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }
}
