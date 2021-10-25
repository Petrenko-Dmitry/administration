package com.administration.service;

import com.administration.dao.UserRepository;
import com.administration.entity.UserGroup;
import com.administration.entity.Users;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long save(Users user){
        return userRepository.save(user).getId();
    }

    public Users getByLogin(String login){
        return userRepository.findByLogin(login);
    }

    @Transactional
    public void setLimitUser(String loginUser, BigDecimal limit) {
        Users user= userRepository.findByLogin(loginUser);
        user.setLimitUser(limit);
        userRepository.save(user);
    }
}
