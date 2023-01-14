package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository  extends JpaRepository<Basket, Long> {
}
