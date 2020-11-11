package com.junbin.mall.service;

import com.junbin.mall.domain.User;
import com.junbin.mall.domain.UserCoupon;
import com.junbin.mall.dto.CouponDto;
import com.junbin.mall.repository.CouponRepository;
import com.junbin.mall.repository.UserCouponRepository;
import com.junbin.mall.repository.UserRepository;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCouponService {

    private final UserCouponRepository userCouponRepository;

    private final UserRepository userRepository;

    public UserCouponService(UserCouponRepository userCouponRepository,
                             UserRepository userRepository) {
        this.userCouponRepository = userCouponRepository;
        this.userRepository = userRepository;
    }

    public List<CouponDto> getUserCoupon(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        List<UserCoupon> userCoupons= userCouponRepository.findAllByUser(user.get());

        return ConvertTool.convertList(userCoupons, CouponDto.class);
    }
}
