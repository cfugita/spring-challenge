package br.com.digitalhouse.springchallenge.dataprovider.DTO;
import java.util.Date;

public class PostDTO {
    private Long postId;
    private String userName;
    private Date date;
    private ProductDTO details;
    private Boolean hasPromo;
    private double discount;

    public PostDTO(Long postId, String userName, Date date, ProductDTO details, Boolean hasPromo, double discount) {
        this.postId = postId;
        this.userName = userName;
        this.date = date;
        this.details = details;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PostDTO() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProductDTO getDetails() {
        return details;
    }

    public void setDetails(ProductDTO details) {
        this.details = details;
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
