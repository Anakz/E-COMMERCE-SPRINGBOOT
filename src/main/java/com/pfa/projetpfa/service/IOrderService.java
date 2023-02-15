package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.OrderVo;
import com.pfa.projetpfa.domaine.ProductVo;

import java.util.List;

public interface IOrderService {
    List<OrderVo> getOrders();

    OrderVo save(OrderVo order);

    OrderVo getOrderById(Long id);

    void delete(Long id);

    List<OrderVo> findAll(int pageId, int size);

    List<OrderVo> sortBy(String fieldName);
}
