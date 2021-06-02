package br.com.digitalhouse.springchallenge.usecases.models.requests;

public class PostRequest {
    private ProductRequest productRequest;
    private Integer category;
    private double price;

    public PostRequest(ProductRequest productRequest, Integer category, double price) {
        this.productRequest = productRequest;
        this.category = category;
        this.price = price;
    }

    public PostRequest() {
    }

    public ProductRequest getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(ProductRequest productRequest) {
        this.productRequest = productRequest;
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
