package com.pfa.projetpfa.service;

import com.pfa.projetpfa.domaine.BillVo;

import java.util.List;

public interface IBillService {
    List<BillVo> getBills();

    BillVo save(BillVo bill);

    BillVo getBillById(Long id);

    void delete(Long id);

    List<BillVo> findAll(int pageId, int size);

    List<BillVo> sortBy(String fieldName);
}
