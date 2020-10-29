package com.junbin.mall.service;

import com.junbin.mall.domain.Admin;
import com.junbin.mall.domain.User;
import com.junbin.mall.dto.AdminLoginDto;
import com.junbin.mall.dto.AdminUserDto;
import com.junbin.mall.exception.ExceptionMessage;
import com.junbin.mall.exception.UserIsNotExistException;
import com.junbin.mall.exception.UserPasswordIsNotCorrectException;
import com.junbin.mall.repository.AdminRepository;
import com.junbin.mall.repository.UserRepository;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<AdminUserDto> getUsers(){
        List<User> users = userRepository.findAll();

        return ConvertTool.convertList(users, AdminUserDto.class);
    }

    public AdminUserDto setUserTag(Long id, String tag) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserIsNotExistException(ExceptionMessage.USER_NOT_EXIST);
        }
        user.get().setTag(tag);
        User userAfterSetTag = userRepository.save(user.get());
        return ConvertTool.convertObject(userAfterSetTag, AdminUserDto.class);
    }
}
