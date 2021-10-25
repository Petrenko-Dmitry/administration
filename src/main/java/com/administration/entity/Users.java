package com.administration.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private  Role role;
    private BigDecimal limitUser;
    @ManyToOne
    private UserGroup group;
}
