package com.administration.controller;

import com.administration.service.UsersGroupService;
import com.administration.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UsersGroupService usersGroupService;
    private final UsersService usersService;

    public AdminController(UsersGroupService usersGroupService,
                           UsersService usersService) {
        this.usersGroupService = usersGroupService;
        this.usersService = usersService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/limit-group")
    public void setLimitGroup(@RequestParam String loginGroup, @RequestParam BigDecimal limit) {
        usersGroupService.setLimitGroup(loginGroup, limit);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/limit-user")
    public void setLimitUser(@RequestParam String loginUser, @RequestParam BigDecimal limit) {
        usersService.setLimitUser(loginUser, limit);
    }

}
