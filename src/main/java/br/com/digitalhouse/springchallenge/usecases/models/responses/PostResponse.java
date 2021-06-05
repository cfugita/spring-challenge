package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.Date;

public class PostResponse implements Comparable<PostResponse>{
    private Long postId;
    private Date date;
    private ProductResponse detail;

    public PostResponse(Long postId, Date date, ProductResponse detail) {
        this.postId = postId;
        this.date = date;
        this.detail = detail;
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

    @Override
    public int compareTo(PostResponse postResponse) {
        if(this.getDate().before(postResponse.getDate())){
            return -1;
        }
        if(this.getDate().after(postResponse.getDate())){
            return 1;
        }
        return 0;
    }
}
