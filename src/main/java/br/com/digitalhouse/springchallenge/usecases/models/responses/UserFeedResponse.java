package br.com.digitalhouse.springchallenge.usecases.models.responses;
import java.util.List;

public class UserFeedResponse {
    private Long userId;
    private String userName;
    private List<PostResponse> posts;

    public UserFeedResponse(Long userId, String userName, List<PostResponse> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public UserFeedResponse() {
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

    public List<PostResponse> getPosts() {
        return posts;
    }

    public void setPosts(List<PostResponse> posts) {
        this.posts = posts;
    }
}
