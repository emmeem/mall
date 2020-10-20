package com.junbin.mall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junbin.mall.dto.UserLoginDto;
import com.junbin.mall.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    private UserLoginDto userLoginDto;

    @BeforeEach
    public void beforeEach() {
        userLoginDto = userLoginDto.builder()
                       .name("junbin")
                       .password("123456")
                       .build();
    }

    @Nested
    class login{
        @Test
        public void should_return_success_when_user_name_and_pwd_correct() throws Exception {
            when(userService.login(userLoginDto)).thenReturn(userLoginDto);

            String jsonData = objectMapper.writeValueAsString(userLoginDto);
            mockMvc.perform(post("/user/login")
                    .content(jsonData)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
            verify(userService).login(userLoginDto);
        }

        @Test
        public void should_throw_exception_when_name_is_empty() throws Exception {
            when(userService.login(userLoginDto)).thenReturn(userLoginDto);

            userLoginDto.setName("");
            String jsonData = objectMapper.writeValueAsString(userLoginDto);
            mockMvc.perform(post("/user/login")
                    .content(jsonData)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message", is("用户名不能为空")));
        }

        @Test
        public void should_throw_exception_when_password_is_empty() throws Exception {
            when(userService.login(userLoginDto)).thenReturn(userLoginDto);

            userLoginDto.setPassword("");
            String jsonData = objectMapper.writeValueAsString(userLoginDto);
            mockMvc.perform(post("/user/login")
                    .content(jsonData)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message", is("用户密码不能为空")));
        }

    }

}
