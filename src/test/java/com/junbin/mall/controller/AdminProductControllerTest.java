package com.junbin.mall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junbin.mall.domain.Picture;
import com.junbin.mall.dto.AdminProductDto;
import com.junbin.mall.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@WebMvcTest(AdminProductController.class)
public class AdminProductControllerTest {
    @MockBean
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    private AdminProductDto adminProductDto;

    private Picture picture;

    @BeforeEach
    public void beforeEach() {
        picture = picture.builder()
                .name("football")
                .note("image")
                .url("/usr/img/2.jpg")
                .build();
        List<Picture> pictures = new ArrayList<>();
        pictures.add(picture);

        adminProductDto = adminProductDto.builder()
                .name("liao")
                .price(14)
                .description("a good product")
                .stock(15L)
                .pictures(pictures)
                .build();
    }
    @Nested
    class create{
        @Test
        public void should_return_created_when_product_info_is_correct() throws Exception {
            when(productService.createProduct(adminProductDto)).thenReturn(adminProductDto);

            String jsonData = objectMapper.writeValueAsString(adminProductDto);
            mockMvc.perform(post("/admin/product")
                    .content(jsonData)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());
            verify(productService).createProduct(adminProductDto);
        }
    }
}
