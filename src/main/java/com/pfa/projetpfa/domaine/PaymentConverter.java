package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Category;
import com.pfa.projetpfa.service.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentConverter {
    public static PaymentVo toVo(Payment bo){
        if (bo == null)
            return null;
        PaymentVo vo = new PaymentVo();
        vo.setId(bo.getId());
        vo.setPaid_date(bo.getPaid_date());
        vo.setAmount(bo.getAmount());
        vo.setUser(bo.getUser());
        vo.setIs_deleted(bo.getIsDeleted());
        return vo;
    }
    public static Payment toBo(PaymentVo vo){
        if (vo == null)
            return null;
        Payment bo = new Payment();
        bo.setId(vo.getId());
        bo.setPaid_date(vo.getPaid_date());
        bo.setAmount(vo.getAmount());
        bo.setUser(vo.getUser());
        bo.setIsDeleted(vo.getIs_deleted());
        return bo;
    }
    public static List<PaymentVo> toListVo(List<Payment> listBo){
        List<PaymentVo> listVo = new ArrayList<>();
        for (Payment payment : listBo) {
            listVo.add(toVo(payment));
        }
        return listVo;
    }
}
