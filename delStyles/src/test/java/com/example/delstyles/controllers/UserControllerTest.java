package com.example.delstyles.controllers;

import com.example.delstyles.dtos.request.UserLoginRequestDto;
import com.example.delstyles.dtos.request.UserRequestDto;
import com.example.delstyles.dtos.response.UserResponseDto;
import com.example.delstyles.enums.UserType;
import com.example.delstyles.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    UserRequestDto requestDto;
    UserLoginRequestDto userLoginRequestDto;
    UserResponseDto responseDto;

    @BeforeEach
    void setUp() {
        requestDto = UserRequestDto.builder()
                .username("Johny")
                .userType(UserType.ADMIN)
                .password("1234")
                .build();

        responseDto = UserResponseDto.builder()
                .username("Johny")
                .build();
    }

    @Test
    void createUser() throws Exception {

        when(userService.createUser(requestDto)).thenReturn(responseDto);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/delstyles/createuser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());
    }

//    @Test
//    void loginUser() throws Exception {
////        when(userService.loginUser(loginRequestDto)).thenReturn(responseDto);
////
////        ResultActions result = mockMvc.perform(post("/delstyles/loginuser")
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(objectMapper.writeValueAsString(requestDto)));
////
////        result.andExpect(status().isOk());
////    }
////
////        when(userService.loginUser(userLoginRequestDto)).thenReturn(responseDto);
////
////        mockMvc.perform(MockMvcRequestBuilders
////                        .post("/delstyles/loginuser")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content(objectMapper.writeValueAsString(userLoginRequestDto)))
////                .andExpect(status().isOk());
////    }
//
//            // Mock the responseDto returned by the userService.loginUser() method
//            UserResponseDto responseDto = new UserResponseDto();
//            // Set the properties of responseDto as needed for successful login
//
//            // Mock the login request data (userLoginRequestDto)
//            UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
//            // Set the properties of userLoginRequestDto for the login request
//
//            // Mock the userService.loginUser() method to return the responseDto
//            when(userService.loginUser(userLoginRequestDto)).thenReturn(responseDto);
//
//            // Perform the POST request to the loginuser endpoint with userLoginRequestDto as content
//            mockMvc.perform(post("/delstyles/loginuser")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(userLoginRequestDto)))
//                    .andDo(print()) // Print the response for debugging (optional)
//                    .andExpect(status().isOk()); // Assert that the status is HTTP 200 OK
//        }

}