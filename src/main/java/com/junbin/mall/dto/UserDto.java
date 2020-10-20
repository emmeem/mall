package com.junbin.mall.dto;

import com.junbin.mall.exception.ExceptionMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class UserDto {
    @NotEmpty(message = ExceptionMessage.USER_NAME_NOT_EMPTY)
    private String name;

    @NotEmpty(message = ExceptionMessage.USER_PASSWORD_NOT_EMPTY)
    @Size(min=6, message = ExceptionMessage.USER_PASSWORD_NOT_LESS_THAN_SIX)
    private String password;

    @NotEmpty(message = ExceptionMessage.USER_PHONE_NOT_EMPTY)
    @Size(min=11, max=11, message = ExceptionMessage.USER_PHONE_LENGTH_IS_ELEVEN)
    private String phone;

    @NotEmpty(message = ExceptionMessage.USER_ADDRESS_NOT_EMPTY)
    private String address;
}
