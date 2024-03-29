package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.Basket;
import com.pfa.projetpfa.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository  extends JpaRepository<Basket, Long> {
    boolean existsByUser(User user);

    Basket findByUser(User user);
    Basket findFirstByOrderByIdDesc();

    List<Basket> findByIsDeletedFalse();
}
