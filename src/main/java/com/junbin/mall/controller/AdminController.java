package com.junbin.mall.controller;

import com.junbin.mall.dto.AdminLoginDto;
import com.junbin.mall.dto.AdminUserDto;
import com.junbin.mall.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/userList")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminUserDto> getUsers() {
        return adminService.getUsers();
    }

    @PostMapping("/user/{id}/{tag}")
    @ResponseStatus(HttpStatus.OK)
    public AdminUserDto setUserTag(@PathVariable Long id,
                                   @PathVariable String tag){
        return adminService.setUserTag(id,tag);
    }
}
