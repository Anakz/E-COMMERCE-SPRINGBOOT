package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Order;
import com.pfa.projetpfa.service.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public static OrderVo toVo(Order bo){
        if (bo == null)
            return null;
        OrderVo vo = new OrderVo();
        vo.setId(bo.getId());
        vo.setOrdered(bo.getOrdered());
        vo.setShipped(bo.getShipped());
        vo.setStatus(bo.getStatus());
        vo.setQuantity(bo.getQuantity());
        vo.setDelivery_price(bo.getDelivery_price());
        vo.setTotal(bo.getTotal());
        vo.setIs_deleted(bo.isIs_deleted());
        vo.setProduct(bo.getProduct());
        vo.setUser(bo.getUser());
        vo.setBill(bo.getBill());
        vo.setDelivery(bo.getDelivery());
        return vo;
    }
    public static Order toBo(OrderVo vo){
        Order bo = new Order();

        bo.setId(vo.getId());
        bo.setOrdered(vo.getOrdered());
        bo.setShipped(vo.getShipped());
        bo.setStatus(vo.getStatus());
        bo.setQuantity(vo.getQuantity());
        bo.setDelivery_price(vo.getDelivery_price());
        bo.setTotal(vo.getTotal());
        bo.setIs_deleted(vo.isIs_deleted());
        bo.setProduct(vo.getProduct());
        bo.setUser(vo.getUser());
        bo.setBill(vo.getBill());
        bo.setDelivery(vo.getDelivery());

        return bo;
    }
    public static List<OrderVo> toListVo(List<Order> listBo){
        List<OrderVo> listVo = new ArrayList<>();
        for (Order order: listBo){
            listVo.add(toVo(order));
        }
        return listVo;
    }
}
