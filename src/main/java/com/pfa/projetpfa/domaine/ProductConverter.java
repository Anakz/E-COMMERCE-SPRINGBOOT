package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter {
    public static ProductVo toVo(Product bo){
        if (bo == null || bo.getId() == null)
            return null;
        ProductVo vo = new ProductVo();
        vo.setId(bo.getId());
        vo.setName(bo.getName());
        vo.setDescription(bo.getDescription());
        vo.setBuying_price(bo.getBuying_price());
        vo.setSelling_price(bo.getSelling_price());
        vo.setStock(bo.getStock());
        vo.setStock_available(bo.getStock_available());
        vo.setWeight(bo.getWeight());
        vo.setCategory(bo.getCategory());
        vo.setBasket(bo.getBasket());
        vo.setOrder(bo.getOrder());
        vo.setImages(bo.getImages());
        vo.setIs_deleted(bo.getIs_deleted());
        return vo;
    }
    public static Product toBo(ProductVo vo){
        Product bo = new Product();

        bo.setId(vo.getId());
        bo.setName(vo.getName());
        bo.setDescription(vo.getDescription());
        bo.setBuying_price(vo.getBuying_price());
        bo.setSelling_price(vo.getSelling_price());
        bo.setStock(vo.getStock());
        bo.setStock_available(vo.getStock_available());
        bo.setWeight(vo.getWeight());
        bo.setCategory(vo.getCategory());
        bo.setBasket(vo.getBasket());
        bo.setOrder(vo.getOrder());
        bo.setImages(vo.getImages());
        bo.setIs_deleted(vo.getIs_deleted());

        return bo;
    }
    public static List<ProductVo> toListVo(List<Product> listBo){
        List<ProductVo> listVo = new ArrayList<>();
        for (Product product: listBo){
            listVo.add(toVo(product));
        }
        return listVo;
    }
}
