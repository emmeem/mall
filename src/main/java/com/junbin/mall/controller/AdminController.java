package com.junbin.mall.controller;

import com.junbin.mall.dto.AdminLoginDto;
import com.junbin.mall.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AdminLoginDto login(@Valid @RequestBody AdminLoginDto adminLoginDto) {
        return adminService.login(adminLoginDto);
    }
}
