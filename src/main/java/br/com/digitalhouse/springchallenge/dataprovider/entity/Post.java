package br.com.digitalhouse.springchallenge.dataprovider.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Integer category;
    private double price;

    public Post(Integer category, double price) {
        this.category = category;
        this.price = price;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
