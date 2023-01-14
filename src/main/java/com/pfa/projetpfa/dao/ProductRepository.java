package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.Category;
import com.pfa.projetpfa.service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
