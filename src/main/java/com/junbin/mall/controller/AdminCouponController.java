package com.junbin.mall.controller;

import com.junbin.mall.dto.AdminCouponDto;
import com.junbin.mall.service.AdminCouponService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable Long id) {
        adminCouponService.deleteCoupon(id);
    }

    @GetMapping("/{companyName}")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminCouponDto> getCoupons(@PathVariable String companyName) {
        return adminCouponService.getCoupons(companyName);
    }

    @DeleteMapping("/userCoupon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserCoupon(@PathVariable Long id) {
        adminCouponService.deleteUserCoupon(id);
    }
}
