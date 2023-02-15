package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.PaymentVo;

import java.util.List;

public interface IPaymentService {

    List<PaymentVo> getPayments();

    PaymentVo save(PaymentVo payment);

    PaymentVo getPaymentById(Long id);

    void delete(Long id);

    List<PaymentVo> findAll(int pageId, int size);

    List<PaymentVo> sortBy(String fieldName);
}
