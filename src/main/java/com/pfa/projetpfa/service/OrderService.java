package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.OrderRepository;
import com.pfa.projetpfa.domaine.OrderConverter;
import com.pfa.projetpfa.domaine.OrderVo;
import com.pfa.projetpfa.domaine.ProductVo;
import com.pfa.projetpfa.service.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderVo> getOrders() {
        List<Order> list = orderRepository.findByIsDeletedFalse();
        return OrderConverter.toListVo(list);
    }

    @Override
    public OrderVo save(OrderVo order) {
        Order createdBo = orderRepository.save(OrderConverter.toBo(order));
        OrderVo createdVo = OrderConverter.toVo(createdBo);
        return createdVo;
    }

    @Override
    public OrderVo getOrderById(Long id) {
        boolean foundOrder = orderRepository.existsById(id);
        if (!foundOrder)
            return null;
        return OrderConverter.toVo(orderRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderVo> findAll(int pageId, int size) {
        Page<Order> result = orderRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));
        return OrderConverter.toListVo(result.getContent());
    }

    @Override
    public List<OrderVo> sortBy(String fieldName) {
        return OrderConverter.toListVo(orderRepository.findAll(Sort.by(fieldName)));
    }
}
