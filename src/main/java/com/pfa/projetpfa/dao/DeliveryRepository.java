package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByIsDeletedFalse();
}
