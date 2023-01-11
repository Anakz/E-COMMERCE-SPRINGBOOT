package com.pfa.projetpfa.service;

import com.pfa.projetpfa.service.model.User;

import java.util.List;

public interface IUserService {

    List<User> getUsers();

    void save(User user);

    User getUserById(Long id);

    void delete(Long id);

    List<User> findByCreditCard(String creditCard);

    List<User> findByRole(String role);

    //Pour la pagination
    List<User> findAll(int pageId, int size);
    //Pour le tri
    List<User> sortBy(String fieldName);
}
