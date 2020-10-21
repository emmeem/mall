package com.junbin.mall.controller;

import com.junbin.mall.dto.UserProductDto;
import com.junbin.mall.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserProductDto> getProductList() {
        return productService.getProducts();
    }

}
