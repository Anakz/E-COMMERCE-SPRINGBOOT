package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.User;
import java.util.Date;

public class PaymentVo {
    private long id;
    private Date paid_date;
    private float amount;
    private User user;
    private boolean is_deleted;

    public PaymentVo() {
    }

    public PaymentVo(long id, Date paid_date, float amount, User user, boolean is_deleted) {
        this.id = id;
        this.paid_date = paid_date;
        this.amount = amount;
        this.user = user;
        this.is_deleted = is_deleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(Date paid_date) {
        this.paid_date = paid_date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
