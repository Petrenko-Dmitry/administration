package com.administration.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserGroupDto {
    private Long id;
    private String name;
    private String role;
    private BigDecimal balanceGroup;
    private BigDecimal limitGroup;
}
