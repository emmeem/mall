package com.junbin.mall.controller;

import com.junbin.mall.dto.UserProductDto;
import com.junbin.mall.service.UserProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    private final UserProductService userProductService;

    public ProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserProductDto> getProducts() {
        return userProductService.getProducts();
    }

}
