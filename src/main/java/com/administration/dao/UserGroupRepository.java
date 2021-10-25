package com.administration.dao;

import com.administration.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    UserGroup findByLoginGroup(String loginGroup);
}
