package com.pfa.projetpfa.service.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date start_date;
    private Date arrived_date;
    @OneToOne
    @JoinColumn(name = "id_order")
    private Order order;
    private boolean isDeleted;

    public Delivery() {
    }

    public Delivery(long id, Date start_date, Date arrived_date, Order order, boolean is_deleted) {
        this.id = id;
        this.start_date = start_date;
        this.arrived_date = arrived_date;
        this.order = order;
        this.isDeleted = is_deleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getArrived_date() {
        return arrived_date;
    }

    public void setArrived_date(Date arrived_date) {
        this.arrived_date = arrived_date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean getIs_deleted() {
        return isDeleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.isDeleted = is_deleted;
    }
}
