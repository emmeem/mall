package com.junbin.mall.dto;

import com.junbin.mall.exception.ExceptionMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class AdminLoginDto {
    @NotEmpty(message = ExceptionMessage.ADMIN_NAME_NOT_EMPTY)
    private String name;

    @NotEmpty(message = ExceptionMessage.ADMIN_PASSWORD_NOT_EMPTY)
    private String password;
}
