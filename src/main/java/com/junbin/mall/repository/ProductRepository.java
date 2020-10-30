package com.junbin.mall.repository;

import com.junbin.mall.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    List<Product> findAllByCompanyName(String companyName);
}
