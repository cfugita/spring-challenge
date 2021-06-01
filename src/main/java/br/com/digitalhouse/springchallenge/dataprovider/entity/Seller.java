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

    @ManyToMany(mappedBy = "following", cascade = CascadeType.PERSIST)
    private List<User> followers = new ArrayList<>();

    public Seller(Long id, String name) {
        this.id = id;
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
}
