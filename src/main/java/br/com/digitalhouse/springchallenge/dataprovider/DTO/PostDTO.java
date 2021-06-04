package br.com.digitalhouse.springchallenge.dataprovider.DTO;
import java.util.Date;

public class PostDTO {
    private Long postId;
    private Date date;
    private ProductDTO details;
    private Integer category;
    private double price;

    public PostDTO(Long postId, Date date, ProductDTO details, Integer category, double price) {
        this.postId = postId;
        this.date = date;
        this.details = details;
        this.category = category;
        this.price = price;
    }

    public PostDTO() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
