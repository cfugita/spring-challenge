package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.List;

public class UserSellerInfoResponse extends UserInfoResponse {

    private List<Long> followers;
    private List<Long> products;

    public UserSellerInfoResponse(Long userId, String userName, Boolean isSeller, List<Long> following, List<Long> followers, List<Long> products) {
        super(userId, userName, isSeller, following);
        this.followers = followers;
        this.products = products;
    }

    public UserSellerInfoResponse(List<Long> followers, List<Long> products) {
        this.followers = followers;
        this.products = products;
    }

    public List<Long> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Long> followers) {
        this.followers = followers;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }
}
