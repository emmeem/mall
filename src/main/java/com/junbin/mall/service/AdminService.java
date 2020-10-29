package com.junbin.mall.service;

import com.junbin.mall.domain.Admin;
import com.junbin.mall.domain.User;
import com.junbin.mall.dto.AdminLoginDto;
import com.junbin.mall.dto.UserDto;
import com.junbin.mall.exception.ExceptionMessage;
import com.junbin.mall.exception.UserIsNotExistException;
import com.junbin.mall.exception.UserPasswordIsNotCorrectException;
import com.junbin.mall.repository.AdminRepository;
import com.junbin.mall.repository.UserRepository;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    private final UserRepository userRepository;

    public AdminService(AdminRepository adminRepository
    ,UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    public AdminLoginDto login(AdminLoginDto adminLoginDto) {
        Admin admin = adminRepository.findUserByName(adminLoginDto.getName())
                .orElseThrow(() -> new UserIsNotExistException(ExceptionMessage.ADMIN_NOT_EXIST));
        if(!admin.getPassword().equals(admin.getPassword())) {
            throw new UserPasswordIsNotCorrectException(ExceptionMessage.ADMIN_PASSWORD_NOT_CORRECT);
        }
        return ConvertTool.convertObject(admin,AdminLoginDto.class);
    }

    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();

        return ConvertTool.convertList(users, UserDto.class);
    }
}
