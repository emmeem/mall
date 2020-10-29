package com.junbin.mall.repository;

import com.junbin.mall.domain.UserCoupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCouponRepository extends CrudRepository<UserCoupon, Long> {

    void deleteById(Long id);
}
