package com.pfa.projetpfa.service.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date paid_date;
    private float amount;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    private boolean isDeleted;

    public Payment() {
    }

    public Payment(long id, Date paid_date, float amount, User user, boolean isDeleted) {
        this.id = id;
        this.paid_date = paid_date;
        this.amount = amount;
        this.user = user;
        this.isDeleted = isDeleted;
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

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
