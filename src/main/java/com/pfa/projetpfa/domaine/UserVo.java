package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Basket;
import com.pfa.projetpfa.service.model.Order;
import com.pfa.projetpfa.service.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class UserVo {
    private long id;
    private String first_name;
    private String last_name;
    private String phone;
    private String address;
    private String credit_card;
    private String email;
    private String password;
    private String role;
    private boolean is_deleted;
    private Payment payment;
    private List<Order> order = new ArrayList<>();
    private Basket basket;

    public UserVo() {
    }

    public UserVo(long id, String first_name, String last_name, String phone, String address, String credit_card, String email, String password, String role, boolean is_deleted, Payment payment, List<Order> order, Basket basket) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.address = address;
        this.credit_card = credit_card;
        this.email = email;
        this.password = password;
        this.role = role;
        this.is_deleted = is_deleted;
        this.payment = payment;
        this.order = order;
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
