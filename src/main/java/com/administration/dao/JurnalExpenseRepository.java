package com.administration.dao;

import com.administration.entity.JurnalExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JurnalExpenseRepository extends JpaRepository<JurnalExpense, Long> {

//    List<JurnalExpense> findByUserIdAndDate(Long id, LocalDateTime date);
//
//    List<JurnalExpense> findByUserId(Long id);
//
//    List<JurnalExpense> findByGroupIdAndDate(Long id, LocalDateTime date);
//
//    List<JurnalExpense> findByGroupId(Long id);
}
