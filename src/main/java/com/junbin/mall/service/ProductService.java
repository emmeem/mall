package com.junbin.mall.service;

import com.junbin.mall.domain.Product;
import com.junbin.mall.dto.AdminProductDto;
import com.junbin.mall.dto.UserProductDto;
import com.junbin.mall.repository.ProductRepository;
import com.junbin.mall.utils.ConvertTool;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Product product = productRepository.save(ConvertTool.convertObject(adminProductDto, Product.class));
        return ConvertTool.convertObject(product, AdminProductDto.class);
    }

}
