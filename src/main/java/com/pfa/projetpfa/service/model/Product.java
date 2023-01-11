package com.pfa.projetpfa.service.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Product")
public class Product {
    @Id
    //@Column(name="id_product" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private float buying_price;
    private float selling_price;
    private int stock;
    private int stock_available;
    private float weight;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_category")
    private Category category;
    @ManyToMany(mappedBy = "product")
    @JoinColumn(name = "id_basket")
    private List<Basket> basket = new ArrayList<>();
    @ManyToMany(mappedBy = "product")
    @JoinColumn(name="id_order")
    private List<Order> order = new ArrayList<>();
    @OneToMany(mappedBy = "product" , fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Collection<Image> images;

    private boolean is_deleted;

    public Product(Long id, String description, float buying_price, float selling_price, int stock, int stock_available, float weight, Category category, Collection<Image> images, boolean is_deleted) {
        this.id = id;
        this.description = description;
        this.buying_price = buying_price;
        this.selling_price = selling_price;
        this.stock = stock;
        this.stock_available = stock_available;
        this.weight = weight;
        this.category = category;
        this.images = images;
        this.is_deleted = is_deleted;
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

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
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
                ", is_deleted=" + is_deleted +
                '}';
    }
}