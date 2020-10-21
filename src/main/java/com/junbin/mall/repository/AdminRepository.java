package com.junbin.mall.repository;

import com.junbin.mall.domain.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Optional<Admin> findUserByName(String name);
}
