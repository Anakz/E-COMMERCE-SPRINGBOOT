package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Basket;

import java.util.ArrayList;
import java.util.List;

public class BasketConverter {
    public static BasketVo toVo(Basket bo) {
        if (bo == null )
            return null;
        BasketVo vo = new BasketVo();
        vo.setId(bo.getId());
        vo.setDate(bo.getDate());
        vo.setQuantity(bo.getQuantity());
        vo.setTotal_price(bo.getTotal_price());
        vo.setUser(bo.getUser());
        vo.setProduct(bo.getProduct());
        vo.setIs_deleted(bo.isIs_deleted());

        return vo;
    }
    public static Basket toBo(BasketVo vo) {
        Basket bo = new Basket();
        bo.setId(vo.getId());
        bo.setDate(vo.getDate());
        bo.setQuantity(vo.getQuantity());
        bo.setTotal_price(vo.getTotal_price());
        bo.setUser(vo.getUser());
        bo.setProduct(vo.getProduct());
        bo.setIs_deleted(vo.isIs_deleted());
        return bo;
    }
    public static List<BasketVo> toListVo(List<Basket> listBo) {
        List<BasketVo> listVo = new ArrayList<>();
        for (Basket basket : listBo) {
            listVo.add(toVo(basket));
        }
        return listVo;
    }
}