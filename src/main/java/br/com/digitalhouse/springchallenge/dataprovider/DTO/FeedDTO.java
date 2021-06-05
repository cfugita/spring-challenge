package br.com.digitalhouse.springchallenge.dataprovider.DTO;

import java.util.List;

public class FeedDTO {
    private Long userId;
    private String userName;
    private List<PostDTO> posts;

    public FeedDTO(Long userId, String userName, List<PostDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public FeedDTO() {
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

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
