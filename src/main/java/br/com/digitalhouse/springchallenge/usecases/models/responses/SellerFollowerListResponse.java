package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.ArrayList;
import java.util.List;

public class SellerFollowerListResponse {
    private Long sellerId;
    private String sellerName;
    private List<UserFollowerResponse> followers;

    public SellerFollowerListResponse(Long sellerId, String sellerName, List<UserFollowerResponse> followers) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.followers = followers;
    }

    public SellerFollowerListResponse() {
        this.followers = new ArrayList<>();
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<UserFollowerResponse> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserFollowerResponse> followers) {
        this.followers = followers;
    }
}
