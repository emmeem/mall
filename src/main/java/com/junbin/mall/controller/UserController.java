package com.junbin.mall.controller;

import com.junbin.mall.domain.User;
import com.junbin.mall.dto.UserDto;
import com.junbin.mall.dto.UserLoginDto;
import com.junbin.mall.service.UserService;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserLoginDto login(@Valid @RequestBody UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@Valid @RequestBody UserDto userDto) {
        return userService.register(userDto);
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable String name) {
        return userService.getUser(name);
    }
}
