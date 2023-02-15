package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.UserVo;
import com.pfa.projetpfa.service.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService  extends UserDetailsService {

    List<UserVo> getUsers();

    void save(UserVo user);

    UserVo getUserById(Long id);

    void delete(Long id);

    boolean existsByEmail(String email);
    UserVo findByEmail(String email);
    UserVo findByEmailAndPassword(String email, String password);

    List<UserVo> findByRole(String role);

    //Pour la pagination
    List<UserVo> findAll(int pageId, int size);
    //Pour le tri
    List<UserVo> sortBy(String fieldName);

    UserDetails loadUserByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);
    UserVo findLastCreated();

}
