package br.com.digitalhouse.springchallenge.usecases.models.responses;

public class PostCountResponse {
    private Long userId;
    private String userName;
    private Integer postCount;

    public PostCountResponse(Long userId, String userName, Integer postCount) {
        this.userId = userId;
        this.userName = userName;
        this.postCount = postCount;
    }

    public PostCountResponse() {
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

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }
}
