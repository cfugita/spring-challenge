package br.com.digitalhouse.springchallenge.usecases.models.requests;

public class PostPromoRequest {
    private Boolean hasPromo;
    private double discount;

    public PostPromoRequest(Boolean hasPromo, double discount) {
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PostPromoRequest() {
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
