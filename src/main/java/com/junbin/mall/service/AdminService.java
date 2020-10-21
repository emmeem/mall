package com.junbin.mall.service;

import com.junbin.mall.domain.Admin;
import com.junbin.mall.dto.AdminLoginDto;
import com.junbin.mall.exception.ExceptionMessage;
import com.junbin.mall.exception.UserIsNotExistException;
import com.junbin.mall.exception.UserPasswordIsNotCorrectException;
import com.junbin.mall.repository.AdminRepository;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminLoginDto login(AdminLoginDto adminLoginDto) {
        Admin admin = adminRepository.findUserByName(adminLoginDto.getName())
                .orElseThrow(() -> new UserIsNotExistException(ExceptionMessage.ADMIN_NOT_EXIST));
        if(!admin.getPassword().equals(admin.getPassword())) {
            throw new UserPasswordIsNotCorrectException(ExceptionMessage.ADMIN_PASSWORD_NOT_CORRECT);
        }
        return ConvertTool.convertObject(admin,AdminLoginDto.class);
    }
}
