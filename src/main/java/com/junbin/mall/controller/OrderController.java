package com.junbin.mall.controller;

import com.junbin.mall.dto.UserOrderDto;
import com.junbin.mall.service.UserOrderService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(tags = "用户订单接口" )
public class OrderController {

    private final UserOrderService userOrderService;

    public OrderController(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserOrderDto create(@RequestBody UserOrderDto userOrderDto) {

        return userOrderService.create(userOrderDto);
    }
}
