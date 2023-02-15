package com.pfa.projetpfa.service.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Category {
    @Id
    //@Column(name="id_category" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category" , fetch = FetchType.EAGER)
    @JsonManagedReference(value = "product-category")
    private Collection<Product> products;
    private boolean isDeleted;

    public Category(Long id, String name, Collection<Product> products, boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.isDeleted = is_deleted;
    }
    public Category(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public boolean isIs_deleted() {
        return isDeleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.isDeleted = is_deleted;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                ", is_deleted=" + isDeleted +
                '}';
    }
}