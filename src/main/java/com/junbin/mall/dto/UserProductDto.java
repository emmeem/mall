package com.junbin.mall.dto;

import com.junbin.mall.domain.Picture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class UserProductDto {

    private String name;

    private Integer price;

    private String description;

    private List<Picture> pictures;

}
