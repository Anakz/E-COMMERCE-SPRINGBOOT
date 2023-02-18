package com.pfa.projetpfa.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Basket {
    @Id
    //@Column(name="id_basket" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private int quantity;
    private float total_price;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    //@JsonBackReference(value = "user-basket")
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable(name = "basket_product", joinColumns = @JoinColumn(name = "id_basket"), inverseJoinColumns = @JoinColumn(name = "id_product"))
        //@JsonManagedReference(value = "basket-product")
    //@JsonBackReference
    //@JsonBackReference(value = "product-basket")
    private List<Product> product = new ArrayList<Product>();
    private boolean isDeleted;


    public Basket() {
    }

    public Basket(long id, Date date, int quantity, float total_price, User user, List<Product> product, boolean is_deleted) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.total_price = total_price;
        this.user = user;
        this.product = product;
        this.isDeleted = is_deleted;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.isDeleted = is_deleted;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProduct() {
        return product;
    }

    public boolean isIs_deleted() {
        return isDeleted;
    }
}
