package br.com.digitalhouse.springchallenge.usecases.models.responses;

public class SellerFollowedResponse {
    private Long sellerId;
    private String sellerName;

    public SellerFollowedResponse(Long sellerId, String sellerName) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
    }

    public SellerFollowedResponse() {
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
}
