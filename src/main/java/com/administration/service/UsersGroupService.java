package com.administration.service;

import com.administration.converter.UserToUserGroupDtoConverter;
import com.administration.dao.UserGroupRepository;
import com.administration.dto.UserGroupDto;
import com.administration.entity.UserGroup;
import com.administration.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsersGroupService {
    private final UserGroupRepository userGroupRepository;
    private final UserToUserGroupDtoConverter userToUserGroupDtoConverter;

    public UsersGroupService(UserGroupRepository userGroupRepository,
                             UserToUserGroupDtoConverter userToUserGroupDtoConverter) {
        this.userGroupRepository = userGroupRepository;
        this.userToUserGroupDtoConverter = userToUserGroupDtoConverter;
    }

    public Long save(UserGroup userGroup) {
        return userGroupRepository.save(userGroup).getId();
    }

    @Transactional
    public List<UserGroupDto> getByLogin(String loginGroup) {
        UserGroup userGroup = userGroupRepository.findByLoginGroup(loginGroup);
        if (userGroup == null) return null;
        List<Users> users = userGroup.getUsers();
        return users.stream()
                .map(one->userToUserGroupDtoConverter.convert(one, userGroup)).collect(Collectors.toList());
    }

    public void setLimitGroup(String loginGroup, BigDecimal limit) {
        UserGroup userGroup = userGroupRepository.findByLoginGroup(loginGroup);
        userGroup.setLimitGroup(limit);
        userGroupRepository.save(userGroup);
    }

}
