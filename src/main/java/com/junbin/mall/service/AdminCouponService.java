package com.junbin.mall.service;

import com.junbin.mall.domain.Coupon;
import com.junbin.mall.dto.AdminCouponDto;
import com.junbin.mall.exception.CouponIsExistException;
import com.junbin.mall.exception.ExceptionMessage;
import com.junbin.mall.repository.CouponRepository;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminCouponService {
    private final CouponRepository couponRepository;

    public AdminCouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }


    public AdminCouponDto createCoupon(AdminCouponDto adminCouponDto) {
        Optional<Coupon> coupon = couponRepository.findCouponByName(adminCouponDto.getName());
        if(coupon.isPresent()) {
            if(coupon.get().getCompanyName() == adminCouponDto.getName())
            throw new CouponIsExistException(ExceptionMessage.COUPON_IS_EXIST);
        }
        Coupon newCoupon = couponRepository.save(ConvertTool.convertObject(adminCouponDto, Coupon.class));
        return ConvertTool.convertObject(newCoupon, AdminCouponDto.class);
    }
}
