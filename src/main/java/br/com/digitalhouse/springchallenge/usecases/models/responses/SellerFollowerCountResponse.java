package br.com.digitalhouse.springchallenge.usecases.models.responses;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SellerFollowerCountResponse {
    private Long sellerId;
    private String sellerName;
    private Integer followerCount;

    public SellerFollowerCountResponse(Long sellerId, String sellerName, Integer followerCount) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.followerCount = followerCount;
    }

    public SellerFollowerCountResponse() {
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

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }
}
