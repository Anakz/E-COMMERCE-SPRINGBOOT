package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.BasketRepository;
import com.pfa.projetpfa.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import com.pfa.projetpfa.domaine.BasketConverter;
import com.pfa.projetpfa.domaine.BasketVo;
import com.pfa.projetpfa.service.model.Basket;

import java.util.List;

@Service
public class BasketService implements IBasketService , CommandLineRunner  {
    @Autowired
    private BasketRepository basketRepository;

    @Override
    public List<BasketVo> getBaskets(){
        List<Basket> list = basketRepository.findAll();
        return BasketConverter.toListVo(list);
    }

    @Override
    public BasketVo save(BasketVo basket) {
        basketRepository.save(BasketConverter.toBo(basket));
        return basket;
    }

    @Override
    public BasketVo findLastCreated() {
        return BasketConverter.toVo(basketRepository.findFirstByOrderByIdDesc());
    }
    @Override
    public BasketVo getBasketById(Long id) {
        boolean found = basketRepository.existsById(id);
        if(!found)
            return null;
        return BasketConverter.toVo(basketRepository.getOne(id));
    }
    @Override
    public BasketVo getBasketByUser(User user) {
        boolean found = basketRepository.existsByUser(user);
        if(!found)
            return null;
        Basket foundBasket = basketRepository.findByUser(user);
        return BasketConverter.toVo(basketRepository.getOne(foundBasket.getId()));
    }

    @Override
    public void delete(Long id) {
        basketRepository.deleteById(id);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}