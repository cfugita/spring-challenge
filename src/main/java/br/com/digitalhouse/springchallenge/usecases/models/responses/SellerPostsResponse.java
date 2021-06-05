package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.List;

public class SellerPostsResponse {
    private Long sellerId;
    private String sellerName;
    List<PostResponse> posts;

    public SellerPostsResponse(Long sellerId, String sellerName, List<PostResponse> posts) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.posts = posts;
    }

    public SellerPostsResponse() {
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

    public List<PostResponse> getPosts() {
        return posts;
    }

    public void setPosts(List<PostResponse> posts) {
        this.posts = posts;
    }
}
