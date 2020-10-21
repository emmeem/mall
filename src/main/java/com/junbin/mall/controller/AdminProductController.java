package com.junbin.mall.controller;

import com.junbin.mall.dto.AdminProductDto;
import com.junbin.mall.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin/product")
public class AdminProductController {
    private final ProductService productService;

    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdminProductDto createProduct(@RequestBody AdminProductDto adminProductDto) {
        return productService.createProduct(adminProductDto);
    }
}
