package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByIsDeletedFalse();
}
