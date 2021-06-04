package br.com.digitalhouse.springchallenge.usecases.models.responses;

public class UserFollowerResponse implements Comparable<UserFollowerResponse> {
    private Long userId;
    private String userName;

    public UserFollowerResponse(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserFollowerResponse() {
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

    @Override
    public int compareTo(UserFollowerResponse o) {
        return Integer.compare(this.getUserName().compareTo(o.getUserName()), 0);
    }
}
