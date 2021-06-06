package br.com.digitalhouse.springchallenge.usecases.models.responses;

public class UserResponse implements Comparable<UserResponse> {
    private Long userId;
    private String userName;

    public UserResponse(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
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
    public int compareTo(UserResponse o) {
        return Integer.compare(this.getUserName().compareTo(o.getUserName()), 0);
    }
}
