package br.com.digitalhouse.springchallenge.usecases.models.responses;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;

import java.util.Date;

public class PostPromoResponse extends PostResponse{
    private Boolean hasPromo;
    private double discount;

    public PostPromoResponse(Long postId, String userName, Date date, ProductResponse detail, Boolean hasPromo, double discount) {
        super(postId, userName, date, detail);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PostPromoResponse(PostDTO postDTO, ProductResponse detail) {
        super(postDTO.getPostId(), postDTO.getUserName(), postDTO.getDate(), detail);
        this.hasPromo = postDTO.getHasPromo();
        this.discount = postDTO.getDiscount();
    }

    public PostPromoResponse(Boolean hasPromo, double discount) {
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
