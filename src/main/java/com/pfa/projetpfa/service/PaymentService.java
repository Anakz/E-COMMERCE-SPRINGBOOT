package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.PaymentRepository;
import com.pfa.projetpfa.domaine.PaymentConverter;
import com.pfa.projetpfa.domaine.PaymentVo;
import com.pfa.projetpfa.service.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public List<PaymentVo> getPayments() {
        List<Payment> list = paymentRepository.findByIsDeletedFalse();
        return PaymentConverter.toListVo(list);
    }

    @Override
    public PaymentVo save(PaymentVo payment) {
        Payment createdBo = paymentRepository.save(PaymentConverter.toBo(payment));
        PaymentVo createdVo = PaymentConverter.toVo(createdBo);
        return createdVo;
    }

    @Override
    public PaymentVo getPaymentById(Long id) {
        boolean foundPayment = paymentRepository.existsById(id);
        if (!foundPayment)
            return null;
        return PaymentConverter.toVo(paymentRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<PaymentVo> findAll(int pageId, int size) {
        Page<Payment> result = paymentRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));
        return PaymentConverter.toListVo(result.getContent());
    }

    @Override
    public List<PaymentVo> sortBy(String fieldName) {
        return PaymentConverter.toListVo(paymentRepository.findAll(Sort.by(fieldName)));
    }
}
