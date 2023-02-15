package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Order;

import java.util.Date;

public class DeliveryVo {
    private long id;
    private Date start_date;
    private Date arrived_date;
    private Order order;
    private boolean is_deleted;

    public DeliveryVo() {
    }

    public DeliveryVo(long id, Date start_date, Date arrived_date, Order order, boolean is_deleted) {
        this.id = id;
        this.start_date = start_date;
        this.arrived_date = arrived_date;
        this.order = order;
        this.is_deleted = is_deleted;
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

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
