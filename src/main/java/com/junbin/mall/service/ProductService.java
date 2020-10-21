package com.junbin.mall.service;

import com.junbin.mall.domain.Picture;
import com.junbin.mall.domain.Product;
import com.junbin.mall.dto.AdminProductDto;
import com.junbin.mall.dto.UserProductDto;
import com.junbin.mall.repository.ProductRepository;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<UserProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return ConvertTool.convertList(products, UserProductDto.class);
    }

    public AdminProductDto createProduct(AdminProductDto adminProductDto) {
        Product product = ConvertTool.convertObject(adminProductDto, Product.class);
        List<Picture> pictureList = adminProductDto.getPictures();
        List<Picture> pictures = pictureList.stream().peek(t-> t.setProduct(product)).collect(Collectors.toList());

        product.setPictures(pictures);
        Product newProduct = productRepository.save(product);
        return ConvertTool.convertObject(newProduct, AdminProductDto.class);
    }

}
