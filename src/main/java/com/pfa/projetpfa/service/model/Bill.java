package com.pfa.projetpfa.service.model;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name="Bill")
public class Bill {
    @Id
    @Column(name="id_bill" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float total_price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    private boolean is_deleted;

    public Bill(Long id, float total_price, Order order, boolean is_deleted) {
        this.id = id;
        this.total_price = total_price;
        this.order = order;
        this.is_deleted = is_deleted;
    }
    public Bill(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", total_price=" + total_price +
                ", order=" + order +
                ", is_deleted=" + is_deleted +
                '}';
    }
}