package com.administration.controller;

import com.administration.dto.UserGroupDto;
import com.administration.service.UsersGroupService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    private final UsersGroupService usersGroupService;

    public UsersController(UsersGroupService usersGroupService) {
        this.usersGroupService = usersGroupService;
    }

    //получение всей семьи
    @RequestMapping(method = RequestMethod.GET, value = "/search-by-login")
    public List<UserGroupDto> allUsersInGroup(@RequestParam String login) {
        return usersGroupService.getByLogin(login);
    }
}
