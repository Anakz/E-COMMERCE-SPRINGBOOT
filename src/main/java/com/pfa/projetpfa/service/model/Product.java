package com.pfa.projetpfa.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Product")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Product {
    @Id
    //@Column(name="id_product" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float buying_price;
    private float selling_price;
    private int stock;
    private int stock_available;
    private float weight;

    @Column(columnDefinition = "integer default 0")
    private int selected_quantity;
    @Column(columnDefinition = "integer default 0")
    private int fournisseur;
    @ManyToOne
    @JsonBackReference(value = "product-category")
    //@JoinColumn(name="id_category")
    private Category category;

    @ManyToMany(mappedBy = "product", fetch = FetchType.EAGER)
    //@JoinColumn(name = "id_basket")
    @JsonBackReference(value = "product-basket")
    private List<Basket> basket = new ArrayList<>();

    @ManyToMany(mappedBy = "product", fetch=FetchType.EAGER)
    //@JoinColumn(name="id_order")
    @JsonBackReference(value = "product-order")
    private List<Order> order = new ArrayList<>();

    @OneToMany(mappedBy = "product" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "product-image")
    private List<Image> images;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Product(Long id, String name, String description, float buying_price, float selling_price, int stock, int stock_available, float weight, int selected_quantity, Category category, List<Basket> basket, List<Order> order, List<Image> images, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.buying_price = buying_price;
        this.selling_price = selling_price;
        this.stock = stock;
        this.stock_available = stock_available;
        this.weight = weight;
        this.selected_quantity = selected_quantity;
        this.category = category;
        this.basket = basket;
        this.order = order;
        this.images = images;
        this.isDeleted = isDeleted;
    }

    public int getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(int fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Basket> getBasket() {
        return basket;
    }

    public void setBasket(List<Basket> basket) {
        this.basket = basket;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public int getSelected_quantity() {
        return selected_quantity;
    }

    public void setSelected_quantity(int selected_quantity) {
        this.selected_quantity = selected_quantity;
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(float buying_price) {
        this.buying_price = buying_price;
    }

    public float getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(float selling_price) {
        this.selling_price = selling_price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_available() {
        return stock_available;
    }

    public void setStock_available(int stock_available) {
        this.stock_available = stock_available;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public boolean getIs_deleted() {
        return isDeleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.isDeleted = is_deleted;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", buying_price=" + buying_price +
                ", selling_price=" + selling_price +
                ", stock=" + stock +
                ", stock_available=" + stock_available +
                ", weight=" + weight +
                ", category=" + category +
                ", images=" + images +
                ", is_deleted=" + isDeleted +
                '}';
    }
}