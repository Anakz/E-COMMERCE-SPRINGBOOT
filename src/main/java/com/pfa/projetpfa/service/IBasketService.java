package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.BasketVo;

import java.util.List;

public interface IBasketService {
    List<BasketVo> getBaskets();
    void save(BasketVo basket);
    BasketVo getBasketById(Long id);
    void delete(Long id);

}