package com.administration.init;

import com.administration.entity.Role;
import com.administration.entity.UserGroup;
import com.administration.entity.Users;
import com.administration.service.UsersGroupService;
import com.administration.service.UsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Order(2)
@Component
public class InitGroup implements CommandLineRunner {

    private final UsersGroupService usersGroupService;
    private final UsersService usersService;

    public InitGroup(UsersGroupService usersGroupService,
                     UsersService usersService) {
        this.usersGroupService = usersGroupService;
        this.usersService = usersService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usersGroupService.getByLogin("first") == null){
            UserGroup userGroup = new UserGroup();
            userGroup.setLoginGroup("first");
            userGroup.setLimitGroup(new BigDecimal("25000"));
            userGroup.setBalance(new BigDecimal("50000"));

            Users usersFather = new Users();
            usersFather.setLogin("admin");
            usersFather.setPassword("password");
            usersFather.setName("father");
            usersFather.setRole(Role.ADMIN);
            usersFather.setGroup(userGroup);

            Users usersSon = new Users();
            usersSon.setName("son");
            usersSon.setLogin("user");
            usersSon.setPassword("password");
            usersSon.setRole(Role.USER);
            usersSon.setGroup(userGroup);

            userGroup.setUsers(List.of(usersFather, usersSon));

            usersGroupService.save(userGroup);
        }

    }
}
