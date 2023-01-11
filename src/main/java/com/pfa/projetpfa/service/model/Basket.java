package com.pfa.projetpfa.service.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Basket {
    @Id
    @Column(name="id_basket" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private int quantity;
    private float total_price;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "basket_product", joinColumns = @JoinColumn(name = "id_basket"), inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> product = new ArrayList<>();
    private boolean is_deleted;


    public Basket() {
    }

    public Basket(long id, Date date, int quantity, float total_price, User user, List<Product> product, boolean is_deleted) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.total_price = total_price;
        this.user = user;
        this.product = product;
        this.is_deleted = is_deleted;
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
        this.is_deleted = is_deleted;
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
        return is_deleted;
    }
}
