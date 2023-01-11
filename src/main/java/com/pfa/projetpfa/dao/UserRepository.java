package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCreditCard(String creditCard);

    List<User> findByRole(String role);
}
