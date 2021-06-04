package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.Date;

public class PostResponse implements Comparable<PostResponse>{
    private Long postId;
    private Date date;
    private ProductResponse detail;
    private Integer category;
    private double price;

    public PostResponse(Long postId, Date date, ProductResponse detail, Integer category, double price) {
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public PostResponse() {
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

    public ProductResponse getDetail() {
        return detail;
    }

    public void setDetail(ProductResponse detail) {
        this.detail = detail;
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

    @Override
    public int compareTo(PostResponse postResponse) {
        if(this.getDate().after(postResponse.getDate())){
            return -1;
        }
        if(this.getDate().before(postResponse.getDate())){
            return 1;
        }
        return 0;
    }
}
