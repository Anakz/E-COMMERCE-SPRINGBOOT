package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.UserRepository;
import com.pfa.projetpfa.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class UserService implements IUserService, CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        List<User> list = userRepository.findAll();
        return list;
    }

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id){
        boolean foundUser = userRepository.existsById(id);
        if (!foundUser){
            return null;
        }
        return userRepository.getOne(id);
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByCreditCard(String creditCard){
        List<User> list = userRepository.findByCreditCard(creditCard);
        return list;
    }

    @Override
    public List<User> findByRole(String role){
        List<User> list = userRepository.findByRole(role);
        return list;
    }

    //Pour la pagination
    @Override
    public List<User> findAll(int pageId, int size){
        //Page<User> result = userRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));
        List<User> result = userRepository.findAll();

        return result;
    }

    //Pour le tri
    @Override
    public List<User> sortBy(String fieldName){

        return userRepository.findAll(Sort.by(fieldName));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.print("This is a UserService.java in the run methode");
    }
}
