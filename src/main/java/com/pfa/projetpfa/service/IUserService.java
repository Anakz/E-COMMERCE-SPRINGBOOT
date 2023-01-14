package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.UserVo;
import com.pfa.projetpfa.service.model.User;

import java.util.List;

public interface IUserService {

    List<UserVo> getUsers();

    void save(UserVo user);

    UserVo getUserById(Long id);

    void delete(Long id);


    List<UserVo> findByRole(String role);

    //Pour la pagination
    List<UserVo> findAll(int pageId, int size);
    //Pour le tri
    List<UserVo> sortBy(String fieldName);
}
