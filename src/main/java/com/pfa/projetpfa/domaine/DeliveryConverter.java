package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Delivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryConverter {
    public static DeliveryVo toVo(Delivery bo) {
        if (bo == null)
            return null;
        DeliveryVo vo = new DeliveryVo();
        vo.setId(bo.getId());
        vo.setStart_date(bo.getStart_date());
        vo.setArrived_date(bo.getArrived_date());
        vo.setOrder(bo.getOrder());
        vo.setIs_deleted(bo.getIs_deleted());
        return vo;
    }
    public static Delivery toBo(DeliveryVo vo) {
        Delivery bo = new Delivery();
        bo.setId(vo.getId());
        bo.setStart_date(vo.getStart_date());
        bo.setArrived_date(vo.getArrived_date());
        bo.setOrder(vo.getOrder());
        bo.setIs_deleted(vo.isIs_deleted());
        return bo;
    }
    public static List<DeliveryVo> toListVo(List<Delivery> listBo) {
        List<DeliveryVo> listVo = new ArrayList<>();
        for (Delivery delivery : listBo) {
            listVo.add(toVo(delivery));
        }
        return listVo;
    }
}
