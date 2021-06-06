package br.com.digitalhouse.springchallenge.usecases.models.responses;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.PostDTO;

import java.util.Date;

public class PostResponse implements Comparable<PostResponse>{
    private Long postId;
    private String userName;
    private Date date;
    private ProductResponse detail;

    public PostResponse(Long postId, String userName, Date date, ProductResponse detail) {
        this.postId = postId;
        this.userName = userName;
        this.date = date;
        this.detail = detail;
    }

    public PostResponse() {
    }

    public PostResponse(PostDTO postDTO, ProductResponse productResponse) {
        this.postId = postDTO.getPostId();
        this.userName = postDTO.getUserName();
        this.date = postDTO.getDate();
        this.detail = productResponse;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
