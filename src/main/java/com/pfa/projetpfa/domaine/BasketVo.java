package com.pfa.projetpfa.domaine;
import com.pfa.projetpfa.service.model.Product;
import com.pfa.projetpfa.service.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasketVo {
    private long id;
    private Date date;
    private int quantity;
    private float total_price;
    private User user;
    private List<Product> product = new ArrayList<Product>();
    private boolean is_deleted;
    public BasketVo(){
        super();
    }

    public BasketVo(long id, Date date, int quantity, float total_price, User user, List<Product> product, boolean is_deleted) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.total_price = total_price;
        this.user = user;
        this.product = product;
        this.is_deleted = is_deleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}