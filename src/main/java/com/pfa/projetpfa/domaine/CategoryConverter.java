package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryConverter {
    public static CategoryVo toVo(Category bo) {
        if (bo == null || bo.getId() ==null)
            return null;
        CategoryVo vo = new CategoryVo();
        vo.setId(bo.getId());
        vo.setName(bo.getName());
        vo.setProducts(bo.getProducts());
        vo.setIs_deleted(bo.isIs_deleted());
        return vo;
    }
    public static Category toBo(CategoryVo vo) {
        Category bo = new Category();
        bo.setId(vo.getId());
        bo.setName(vo.getName());
        bo.setProducts(vo.getProducts());
        bo.setIs_deleted(vo.isIs_deleted());
        return bo;
    }
    public static List<CategoryVo> toListVo(List<Category> listBo) {
        List<CategoryVo> listVo = new ArrayList<>();
        for (Category category : listBo) {
            listVo.add(toVo(category));
        }
        return listVo;
    }
}