package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Order;

public class BillVo {
    private Long id;
    private float total_price;
    private Order order;
    private boolean is_deleted;

    public BillVo() {
    }

    public BillVo(Long id, float total_price, Order order, boolean is_deleted) {
        this.id = id;
        this.total_price = total_price;
        this.order = order;
        this.is_deleted = is_deleted;
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
}
