package br.com.digitalhouse.springchallenge.usecases.models.responses;

public class SellerPromoPostCountResponse {
    private Long sellerId;
    private String sellerName;
    private Integer promoPostCount;

    public SellerPromoPostCountResponse(Long sellerId, String sellerName, Integer promoPostCount) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.promoPostCount = promoPostCount;
    }

    public SellerPromoPostCountResponse() {
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

    public Integer getPromoPostCount() {
        return promoPostCount;
    }

    public void setPromoPostCount(Integer promoPostCount) {
        this.promoPostCount = promoPostCount;
    }
}
