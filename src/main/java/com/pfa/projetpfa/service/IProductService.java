package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.ProductVo;
import com.pfa.projetpfa.service.model.Category;

import java.util.List;

public interface IProductService {
    List<ProductVo> getProducts();

    void save(ProductVo product);

    ProductVo getProductById(Long id);

    void delete(Long id);

    List<ProductVo> getProductsByCategory(Category category);

    List<ProductVo> findAll(int pageId, int size);

    List<ProductVo> sortBy(String fieldName);
}
