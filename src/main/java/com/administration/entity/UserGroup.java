package com.administration.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="user_group")
@Data
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String loginGroup;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name="group_id")
    private List<Users> users;

    private BigDecimal balance;

    private BigDecimal limitGroup;
}
