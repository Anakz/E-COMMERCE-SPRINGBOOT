package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Product;

public class ImageVo {
    private Long id;
    private String img;
    private Product product;
    private boolean is_deleted;

    public ImageVo() {
    }

    public ImageVo(Long id, String img, Product product, boolean is_deleted) {
        this.id = id;
        this.img = img;
        this.product = product;
        this.is_deleted = is_deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
