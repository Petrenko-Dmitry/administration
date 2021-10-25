package com.administration.converter;

import com.administration.dto.UserGroupDto;
import com.administration.entity.UserGroup;
import com.administration.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserToUserGroupDtoConverter {

    public UserGroupDto convert(Users source, UserGroup userGroup) {
        UserGroupDto result = new UserGroupDto();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setRole(source.getRole().name());
        result.setLimitGroup(userGroup.getLimitGroup());
        result.setBalanceGroup(userGroup.getBalance());

        return result;
    }
}
