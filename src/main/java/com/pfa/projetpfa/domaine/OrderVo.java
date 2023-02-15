package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Bill;
import com.pfa.projetpfa.service.model.Delivery;
import com.pfa.projetpfa.service.model.Product;
import com.pfa.projetpfa.service.model.User;

import java.util.ArrayList;
import java.util.List;

public class OrderVo {
    private long id;
    private String ordered;
    private String shipped;
    private String status;
    private int quantity;
    private float delivery_price;
    private float total;
    private boolean is_deleted;
    private List<Product> product = new ArrayList<>();
    private User user;
    private Bill bill;
    private Delivery delivery;

    public OrderVo() {
    }

    public OrderVo(long id, String ordered, String shipped, String status, int quantity, float delivery_price, float total, boolean is_deleted, List<Product> product, User user, Bill bill, Delivery delivery) {
        this.id = id;
        this.ordered = ordered;
        this.shipped = shipped;
        this.status = status;
        this.quantity = quantity;
        this.delivery_price = delivery_price;
        this.total = total;
        this.is_deleted = is_deleted;
        this.product = product;
        this.user = user;
        this.bill = bill;
        this.delivery = delivery;
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

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
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
}
