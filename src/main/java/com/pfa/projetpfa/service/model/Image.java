package com.pfa.projetpfa.service.model;
import jakarta.persistence.*;
@Entity
@Table(name="Image")
public class Image {
    @Id
    @Column(name = "id_image", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private Product product;
    private boolean is_deleted;

    public Image(Long id, String img, Product product, boolean is_deleted) {
        this.id = id;
        this.img = img;
        this.product = product;
        this.is_deleted = is_deleted;
    }

    public Image() {

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

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", product=" + product +
                ", is_deleted=" + is_deleted +
                '}';
    }
}