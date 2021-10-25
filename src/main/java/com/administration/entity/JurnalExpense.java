package com.administration.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class JurnalExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Long userId;
    private Long groupId;
    private BigDecimal sumExpense;
    private BigDecimal sumRefill;
}
