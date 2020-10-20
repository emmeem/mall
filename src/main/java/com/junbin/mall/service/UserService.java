package com.junbin.mall.service;

import com.junbin.mall.domain.User;
import com.junbin.mall.dto.UserLoginDto;
import com.junbin.mall.exception.ExceptionMessage;
import com.junbin.mall.exception.UserIsNotExistException;
import com.junbin.mall.exception.UserPasswordIsNotCorrectException;
import com.junbin.mall.repository.UserRepository;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserLoginDto login(UserLoginDto userLoginDto) {
       User user = userRepository.findUserByName(userLoginDto.getName())
                 .orElseThrow(() -> new UserIsNotExistException(ExceptionMessage.USER_NOT_EXIST));
       if(!user.getPassword().equals(user.getPassword())) {
           throw new UserPasswordIsNotCorrectException(ExceptionMessage.USER_PASSWORD_NOT_CORRECT);
       }
       return ConvertTool.convertObject(user,UserLoginDto.class);
    }
}
