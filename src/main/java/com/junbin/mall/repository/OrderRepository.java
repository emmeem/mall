package com.junbin.mall.repository;

import com.junbin.mall.domain.MallOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<MallOrder, Long> {

}
