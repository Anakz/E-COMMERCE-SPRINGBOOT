package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.DeliveryVo;

import java.util.List;

public interface IDeliveryService {
    List<DeliveryVo> getDeliveries();

    DeliveryVo save(DeliveryVo delivery);

    DeliveryVo getDeliveryById(Long id);

    void delete(Long id);

    List<DeliveryVo> findAll(int pageId, int size);

    List<DeliveryVo> sortBy(String fieldName);
}
