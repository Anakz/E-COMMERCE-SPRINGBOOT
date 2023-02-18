package com.pfa.projetpfa.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orderr")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ordered;
    private String shipped;
    private String status;
    private int quantity;
    private float delivery_price;
    private float total;
    private boolean isDeleted;
    @ManyToMany(fetch=FetchType.EAGER)
    //@JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "id_order"), inverseJoinColumns = @JoinColumn(name = "id_product"))
    //@JsonBackReference(value = "product-order")
    private List<Product> product = new ArrayList<>();
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonBackReference(value = "user-order")
    private User user;
    @OneToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;
    @OneToOne
    @JoinColumn(name = "id_delivery")
    private Delivery delivery;

    public Order() {
    }

    public Order(long id, String ordered, String shipped, String status, int quantity, float delivery_price, float total, List<Product> product, User user, Bill bill, Delivery delivery, boolean is_deleted) {
        this.id = id;
        this.ordered = ordered;
        this.shipped = shipped;
        this.status = status;
        this.quantity = quantity;
        this.delivery_price = delivery_price;
        this.total = total;
        this.product = product;
        this.user = user;
        this.bill = bill;
        this.delivery = delivery;
        this.isDeleted = is_deleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrdered() {
        return ordered;
    }

    public void setOrdered(String ordered) {
        this.ordered = ordered;
    }

    public String getShipped() {
        return shipped;
    }

    public void setShipped(String shipped) {
        this.shipped = shipped;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(float delivery_price) {
        this.delivery_price = delivery_price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public boolean isIs_deleted() {
        return isDeleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.isDeleted = is_deleted;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordered=" + ordered +
                ", shipped=" + shipped +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", delivery_price=" + delivery_price +
                ", total=" + total +
                ", product=" + product +
                ", user=" + user +
                ", bill=" + bill +
                ", delivery=" + delivery +
                ", is_deleted=" + isDeleted +
                '}';
    }
}