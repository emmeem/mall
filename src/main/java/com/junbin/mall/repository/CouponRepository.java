package com.junbin.mall.repository;

import com.junbin.mall.domain.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {
    Optional<Coupon> findCouponByName(String name);

    Coupon findCouponByCompanyNameAndType(String Company, String Type);
}
