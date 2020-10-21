package com.junbin.mall.controller;

import com.junbin.mall.dto.AdminProductDto;
import com.junbin.mall.service.AdminProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/product")
public class AdminProductController {
    private final AdminProductService adminProductService;

    public AdminProductController(AdminProductService adminProductService) {
        this.adminProductService = adminProductService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdminProductDto createProduct(@RequestBody AdminProductDto adminProductDto) {
        return adminProductService.createProduct(adminProductDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AdminProductDto> getProducts() {
        return adminProductService.getProducts();
    }
}
