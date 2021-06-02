package br.com.digitalhouse.springchallenge.dataprovider.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SELLER")
public class Seller {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "following", targetEntity = User.class, cascade = CascadeType.PERSIST)
    private List<User> followers = new ArrayList<>();

    @OneToMany(mappedBy = "seller", targetEntity = Product.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    public Seller(String name) {
        this.name = name;
    }

    public Seller() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
    public void addFollower(User user){
        this.getFollowers().add(user);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.getProducts().add(product);
    }
}
