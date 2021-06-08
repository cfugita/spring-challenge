package br.com.digitalhouse.springchallenge.usecases.models.requests;

public class ProductRequest {
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Integer category;
    private double price;

    public ProductRequest(String name, String type, String brand, String color, String notes, Integer category, double price) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
        this.category = category;
        this.price = price;
    }

    public ProductRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
