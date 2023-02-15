package com.pfa.projetpfa.dao;

import com.pfa.projetpfa.service.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository  extends JpaRepository<Bill, Long> {
    List<Bill> findByIsDeletedFalse();
}
