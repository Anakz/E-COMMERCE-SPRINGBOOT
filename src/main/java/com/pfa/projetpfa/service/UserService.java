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
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService, CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserVo> getUsers(){
        List<User> list = userRepository.findAll();
        return UserConverter.toListVo(list);
    }

    @Override
    public void save(UserVo user){

        userRepository.save(UserConverter.toBo(user));
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

    @Override
    public void run(String... args) throws Exception {
        System.out.print("This is a UserService.java in the run methode");
    }
}
