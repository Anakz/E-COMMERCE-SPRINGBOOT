package com.pfa.projetpfa.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class User {

    @Id
    //@Column(name="id_user" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String first_name;
    private String last_name;
    private String phone;
    private String address;
    private String credit_card;
    private String email;
    private String password;
    private String role;
    private boolean isDeleted;
    @OneToOne
    @JoinColumn(name = "id_user")
    private Payment payment;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_order")
    @JsonBackReference(value = "user-order")
    private List<Order> order = new ArrayList<>();
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_basket")
    @JsonBackReference(value = "user-basket")
    private Basket basket;

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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User() {
    }

    public User(long id, String first_name, String last_name, String phone, String address, String credit_card, String email, String password, String role, boolean is_deleted) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.address = address;
        this.credit_card = credit_card;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isDeleted = is_deleted;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.isDeleted = is_deleted;
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isIs_deleted() {
        return isDeleted;
    }

    @Override
    public String toString() {
        return "User{" +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", role='" + role + '\'' +
                ", is_deleted=" + isDeleted +
                '}';
    }
}
