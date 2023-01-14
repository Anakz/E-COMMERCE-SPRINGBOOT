package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
    public void save(BasketVo basket) {
        basketRepository.save(BasketConverter.toBo(basket));
    }

    @Override
    public BasketVo getBasketById(Long id) {
        boolean found = basketRepository.existsById(id);
        if(!found)
            return null;
        return BasketConverter.toVo(basketRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        basketRepository.deleteById(id);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}