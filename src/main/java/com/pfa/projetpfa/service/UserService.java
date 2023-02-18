package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.UserRepository;
import com.pfa.projetpfa.domaine.UserConverter;
import com.pfa.projetpfa.domaine.UserVo;
import com.pfa.projetpfa.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserVo> getUsers(){
        List<User> list = userRepository.findByIsDeletedFalse();
        return UserConverter.toListVo(list);
    }

    @Override
    public void save(UserVo userVo){
        /*User user = UserConverter.toBo(userVo);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);*/
        userRepository.save(UserConverter.toBo(userVo));
    }

    @Override
    public UserVo getUserById(Long id){
        boolean foundUser = userRepository.existsById(id);
        if (!foundUser){
            return null;
        }
        return UserConverter.toVo(userRepository.getOne(id));
    }

    @Override
    public void delete(Long id){

        userRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    public UserVo findLastCreated() {
        return UserConverter.toVo(userRepository.findFirstByOrderByIdDesc());
    }



    @Override
    public UserVo findByEmail(String email) {
        if (email == null || email.trim().equals(""))
            throw new BusinessException("login is empty");
        User bo = userRepository.findByEmail(email);
        if (bo == null)
            throw new BusinessException("No user with this login");
        UserVo vo = UserConverter.toVo(bo);
        return vo;
    }

    @Override
    public UserVo findByEmailAndPassword(String email, String password) {
        if (email == null || email.trim().equals("") && password == null || password.trim().equals(""))
            throw new BusinessException("login is empty");
        User bo = userRepository.findByEmailAndPassword(email, password);
        if (bo == null)
            throw new BusinessException("No user with this login");
        UserVo vo = UserConverter.toVo(bo);
        return vo;
    }


    @Override
    public List<UserVo> findByRole(String role){
        List<User> list = userRepository.findByRole(role);
        return UserConverter.toListVo(list);
    }

    //Pour la pagination
    @Override
    public List<UserVo> findAll(int pageId, int size){
        Page<User> result = userRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));

        return UserConverter.toListVo(result.getContent());
    }

    //Pour le tri
    @Override
    public List<UserVo> sortBy(String fieldName){

        return UserConverter.toListVo(userRepository.findAll(Sort.by(fieldName)));
    }
/*
    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        boolean enable = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection<? extends GrantedAuthority> authorities = new ArrayList<>(Integer.parseInt(user.getRole()));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), enable, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities
                );
    }/*


    @Override
    public void run(String... args) throws Exception {
        System.out.print("This is a UserService.java in the run methode");
    }
    /*
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        boolean enable = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection<? extends GrantedAuthority> authorities = new ArrayList<>(Integer.parseInt(user.getRole()));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), enable, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities
        );
    }*/
}
