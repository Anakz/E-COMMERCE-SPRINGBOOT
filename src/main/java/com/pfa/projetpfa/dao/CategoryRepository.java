package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}
