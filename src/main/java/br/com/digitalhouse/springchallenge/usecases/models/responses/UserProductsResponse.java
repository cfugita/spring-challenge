package br.com.digitalhouse.springchallenge.usecases.models.responses;

import java.util.List;

public class UserProductsResponse {
    private Long userId;
    private List<ProductResponse> products;

    public UserProductsResponse(Long userId, List<ProductResponse> products) {
        this.userId = userId;
        this.products = products;
    }

    public UserProductsResponse() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}
