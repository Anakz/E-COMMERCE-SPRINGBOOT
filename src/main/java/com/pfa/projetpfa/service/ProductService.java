package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.ProductRepository;
import com.pfa.projetpfa.domaine.ProductConverter;
import com.pfa.projetpfa.domaine.ProductVo;
import com.pfa.projetpfa.service.model.Category;
import com.pfa.projetpfa.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService, CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductVo> getProducts() {
        List<Product> list = productRepository.findAll();
        return ProductConverter.toListVo(list);
    }

    @Override
    public void save(ProductVo product) {
        productRepository.save(ProductConverter.toBo(product));
    }

    @Override
    public ProductVo getProductById(Long id) {
        boolean foundProduct = productRepository.existsById(id);
        if (!foundProduct)
            return null;
        return ProductConverter.toVo(productRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductVo> getProductsByCategory(Category category) {
        List<Product> list = productRepository.findByCategory(category);
        return ProductConverter.toListVo(list);
    }

    @Override
    public List<ProductVo> findAll(int pageId, int size) {
        Page<Product> result = productRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));
        return ProductConverter.toListVo(result.getContent());
    }

    @Override
    public List<ProductVo> sortBy(String fieldName) {
        return ProductConverter.toListVo(productRepository.findAll(Sort.by(fieldName)));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.print("This is a ProductService.java in the run methode");
    }
}
