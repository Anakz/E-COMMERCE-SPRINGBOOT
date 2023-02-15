package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findByRole(String role);
    User findByEmail(String email);
    boolean existsByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findFirstByOrderByIdDesc();

    boolean existsByEmailAndPassword(String email, String password);

    List<User> findByIsDeletedFalse();
}
