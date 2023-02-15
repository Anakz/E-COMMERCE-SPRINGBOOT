package com.pfa.projetpfa.service;


import com.pfa.projetpfa.dao.DeliveryRepository;
import com.pfa.projetpfa.domaine.DeliveryConverter;
import com.pfa.projetpfa.domaine.DeliveryVo;
import com.pfa.projetpfa.service.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Override
    public List<DeliveryVo> getDeliveries() {
        List<Delivery> list = deliveryRepository.findByIsDeletedFalse();
        return DeliveryConverter.toListVo(list);
    }

    @Override
    public DeliveryVo save(DeliveryVo delivery) {
        Delivery createdBo = deliveryRepository.save(DeliveryConverter.toBo(delivery));
        DeliveryVo createdVo = DeliveryConverter.toVo(createdBo);
        return createdVo;
    }

    @Override
    public DeliveryVo getDeliveryById(Long id) {
        boolean foundDelivery = deliveryRepository.existsById(id);
        if (!foundDelivery)
            return null;
        return DeliveryConverter.toVo(deliveryRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public List<DeliveryVo> findAll(int pageId, int size) {
        Page<Delivery> result = deliveryRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));
        return DeliveryConverter.toListVo(result.getContent());
    }

    @Override
    public List<DeliveryVo> sortBy(String fieldName) {
        return DeliveryConverter.toListVo(deliveryRepository.findAll(Sort.by(fieldName)));
    }
}
