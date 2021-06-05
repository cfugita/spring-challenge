package br.com.digitalhouse.springchallenge.dataprovider.DTO;
import java.util.Date;

public class PostDTO {
    private Long postId;
    private Date date;
    private ProductDTO details;

    public PostDTO(Long postId, Date date, ProductDTO details) {
        this.postId = postId;
        this.date = date;
        this.details = details;
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

}
