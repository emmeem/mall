package com.junbin.mall.controller;

import com.junbin.mall.dto.AdminCouponDto;
import com.junbin.mall.service.AdminCouponService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/admin/coupon")
public class AdminCouponController {
    private final AdminCouponService adminCouponService;

    public AdminCouponController(AdminCouponService adminCouponService) {
        this.adminCouponService = adminCouponService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdminCouponDto createCoupon(@Valid @RequestBody AdminCouponDto adminCouponDto) {
        return adminCouponService.createCoupon(adminCouponDto);
    }

}
