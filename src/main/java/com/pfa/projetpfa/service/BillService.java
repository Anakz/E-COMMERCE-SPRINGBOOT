package com.pfa.projetpfa.service;

import com.pfa.projetpfa.dao.BillRepository;
import com.pfa.projetpfa.domaine.BillConverter;
import com.pfa.projetpfa.domaine.BillVo;
import com.pfa.projetpfa.service.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BillService implements IBillService {

    @Autowired
    private BillRepository billRepository;
    @Override
    public List<BillVo> getBills() {
        List<Bill> list = billRepository.findByIsDeletedFalse();
        return BillConverter.toListVo(list);
    }

    @Override
    public BillVo save(BillVo bill) {
        Bill createBo = billRepository.save(BillConverter.toBo(bill));
        BillVo createVo = BillConverter.toVo(createBo);
        return createVo;
    }

    @Override
    public BillVo getBillById(Long id) {
        boolean foundBill = billRepository.existsById(id);
        if (!foundBill)
            return null;
        return BillConverter.toVo(billRepository.getOne(id));
    }

    @Override
    public void delete(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<BillVo> findAll(int pageId, int size) {
        Page<Bill> result = billRepository.findAll(PageRequest.of(pageId, size, Sort.Direction.ASC, "name"));
        return BillConverter.toListVo(result.getContent());
    }

    @Override
    public List<BillVo> sortBy(String fieldName) {
        return BillConverter.toListVo(billRepository.findAll(Sort.by(fieldName)));
    }
}
