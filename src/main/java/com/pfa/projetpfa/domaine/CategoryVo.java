package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Product;

import java.util.Collection;

public class CategoryVo {
    private Long id;
    private String name;
    private Collection<Product> products;
    private boolean is_deleted;

    public CategoryVo(){
        super();
    }

    public CategoryVo(Long id, String name, Collection<Product> products, boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.is_deleted = is_deleted;
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
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}