package br.com.digitalhouse.springchallenge.dataprovider.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "User_Seller",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "seller_id")}
    )
    private List<Seller> following = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public User() {
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

    public List<Seller> getFollowing() {
        return following;
    }

    public void setFollowing(List<Seller> following) {
        this.following = following;
    }

    public void addFollowing(Seller seller){
        this.getFollowing().add(seller);
    }
}
