package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Bill;
import com.pfa.projetpfa.service.model.Order;
import com.pfa.projetpfa.service.model.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

public class BillConverter {
    public static BillVo toVo(Bill bo){
        if (bo == null || bo.getId() == null)
            return null;
        BillVo vo = new BillVo();
        vo.setId(bo.getId());
        vo.setTotal_price(bo.getTotal_price());
        vo.setOrder(bo.getOrder());
        vo.setIs_deleted(bo.isIs_deleted());
        return vo;
    }
    public static Bill toBo(BillVo vo){
        if (vo == null || vo.getId() == null)
            return null;
        Bill bo = new Bill();
        bo.setId(vo.getId());
        bo.setTotal_price(vo.getTotal_price());
        bo.setOrder(vo.getOrder());
        bo.setIs_deleted(vo.isIs_deleted());
        return bo;
    }
    public static List<BillVo> toListVo(List<Bill> listBo){
        List<BillVo> listVo = new ArrayList<>();
        for (Bill bill: listBo){
            listVo.add(toVo(bill));
        }
        return listVo;
    }
}
