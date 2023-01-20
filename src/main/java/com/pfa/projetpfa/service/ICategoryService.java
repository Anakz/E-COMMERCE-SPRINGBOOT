package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.CategoryVo;

import java.util.List;

public interface ICategoryService {
    List<CategoryVo> getCategories();
    void save(CategoryVo category);

    CategoryVo getCategoryById(Long id);
    void delete(Long id);

    List<CategoryVo> findByName(String name);

    List<CategoryVo> getCategoryByName(String categoryVoName);
}