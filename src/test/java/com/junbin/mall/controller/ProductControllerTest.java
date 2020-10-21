package com.junbin.mall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junbin.mall.domain.Picture;
import com.junbin.mall.dto.UserProductDto;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    private UserProductDto userProductDto;
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

        userProductDto = userProductDto.builder()
                .name("liao")
                .price(14)
                .description("a good product")
                .pictures(pictures)
                .build();
    }

    @Nested
    class getProducts {
        @Test
        public void should_return_product_list() throws Exception {
            List<UserProductDto> userProductDtos = new ArrayList<>();
            userProductDtos.add(userProductDto);
            when(productService.getProducts()).thenReturn(userProductDtos);

            String jsonData = objectMapper.writeValueAsString(userProductDtos);
            mockMvc.perform(get("/product/"+ userProductDto.getName())
                    .content(jsonData)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
            verify(productService).getProducts();
        }
    }

}
