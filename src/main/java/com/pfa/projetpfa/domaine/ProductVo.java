package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Basket;
import com.pfa.projetpfa.service.model.Category;
import com.pfa.projetpfa.service.model.Image;
import com.pfa.projetpfa.service.model.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductVo {

    private Long id;
    private String name;
    private String description;
    private float buying_price;
    private float selling_price;
    private int stock;
    private int stock_available;

    private int fournisseur;
    private float weight;
    private Category category;
    private List<Basket> basket = new ArrayList<>();
    private List<Order> order = new ArrayList<>();
    private List<Image> images;
    private int selected_quantity;
    private boolean is_deleted;

    public ProductVo() {
    }

    public ProductVo(Long id, String name, String description, float buying_price, float selling_price, int stock, int stock_available, int fournisseur, float weight, Category category, List<Basket> basket, List<Order> order, List<Image> images, int selected_quantity, boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.buying_price = buying_price;
        this.selling_price = selling_price;
        this.stock = stock;
        this.stock_available = stock_available;
        this.fournisseur = fournisseur;
        this.weight = weight;
        this.category = category;
        this.basket = basket;
        this.order = order;
        this.images = images;
        this.selected_quantity = selected_quantity;
        this.is_deleted = is_deleted;
    }

    public int getSelected_quantity() {
        return selected_quantity;
    }

    public void setSelected_quantity(int selected_quantity) {
        this.selected_quantity = selected_quantity;
    }

    public ProductVo(ProductVo createdProduct) {
        this.id = createdProduct.id;
        this.name = createdProduct.name;
        this.description = createdProduct.description;
        this.buying_price = createdProduct.buying_price;
        this.selling_price = createdProduct.selling_price;
        this.stock = createdProduct.stock;
        this.stock_available = createdProduct.stock_available;
        this.weight = createdProduct.weight;
        this.category = createdProduct.category;
        this.basket = createdProduct.basket;
        this.order = createdProduct.order;
        this.images = createdProduct.images;
        this.is_deleted = createdProduct.is_deleted;
        this.setFournisseur(createdProduct.getFournisseur());
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

    @Override
    public String toString() {
        return "ProductVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_deleted=" + is_deleted +
                '}';
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

}
