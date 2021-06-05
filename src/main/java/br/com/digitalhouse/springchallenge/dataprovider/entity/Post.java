package br.com.digitalhouse.springchallenge.dataprovider.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private Boolean hasPromo;
    private double discount;


    public Post() {
        this.date = Calendar.getInstance().getTime();
        this.hasPromo = false;
        this.discount = 0.0;
    }

    public Post(double discount) {
        this.date = Calendar.getInstance().getTime();
        this.hasPromo = true;
        this.discount = discount;
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

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
