package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.BasketVo;
import com.pfa.projetpfa.service.model.User;

import java.util.List;

public interface IBasketService {
    List<BasketVo> getBaskets();
    BasketVo save(BasketVo basket);
    BasketVo getBasketById(Long id);
    BasketVo getBasketByUser(User user);
    void delete(Long id);

    BasketVo findLastCreated();
}