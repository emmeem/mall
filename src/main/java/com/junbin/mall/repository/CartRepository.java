package com.junbin.mall.repository;


import com.junbin.mall.domain.Cart;
import com.junbin.mall.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findByProduct(Product product);

    Optional<Cart> findAllByUserId(Long userId);
}

