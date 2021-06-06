package br.com.digitalhouse.springchallenge.usecases.models.responses;

import br.com.digitalhouse.springchallenge.dataprovider.DTO.ProductDTO;

public class ProductResponse {
    private Long productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Integer category;
    private double price;

    public ProductResponse(Long productId, String productName, String type, String brand, String color, String notes, Integer category, double price) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
        this.category = category;
        this.price = price;
    }

    public ProductResponse() {
    }

    public ProductResponse(ProductDTO productDTO) {
        this.productId = productDTO.getProductId();
        this.productName = productDTO.getProductName();
        this.type = productDTO.getType();
        this.brand = productDTO.getBrand();
        this.color = productDTO.getColor();
        this.notes = productDTO.getNotes();
        this.category = productDTO.getCategory();
        this.price = productDTO.getPrice();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
