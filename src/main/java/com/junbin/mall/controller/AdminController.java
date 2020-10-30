package com.junbin.mall.controller;

import com.junbin.mall.dto.AdminLoginDto;
import com.junbin.mall.dto.AdminUserDto;
import com.junbin.mall.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
@Api(tags = "管理员")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "管理员登陆",httpMethod = "POST")
    public AdminLoginDto login(@Valid @RequestBody AdminLoginDto adminLoginDto) {
        return adminService.login(adminLoginDto);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "获取所有用户信息", httpMethod = "GET")
    public List<AdminUserDto> getUsers() {
        return adminService.getUsers();
    }

    @PostMapping("/user/{id}/{tag}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "给用户设置标签", httpMethod = "POST")
    public AdminUserDto setUserTag(@PathVariable Long id,
                                   @PathVariable String tag){
        return adminService.setUserTag(id,tag);
    }
}
