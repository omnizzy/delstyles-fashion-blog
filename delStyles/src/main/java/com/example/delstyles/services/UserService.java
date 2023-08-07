package com.example.delstyles.services;

import com.example.delstyles.dtos.request.UserLoginRequestDto;
import com.example.delstyles.dtos.request.UserRequestDto;
import com.example.delstyles.dtos.response.UserResponseDto;
import org.springframework.stereotype.Component;


public interface UserService {

    UserResponseDto createUser(UserRequestDto request);
    UserResponseDto loginUser(UserLoginRequestDto request);
}
