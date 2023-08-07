package com.example.delstyles.controllers;

import com.example.delstyles.dtos.request.UserLoginRequestDto;
import com.example.delstyles.dtos.request.UserRequestDto;
import com.example.delstyles.dtos.response.UserResponseDto;
import com.example.delstyles.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/delstyles")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto request) {
        try {
            UserResponseDto response = userService.createUser(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping(path = "/loginuser")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequestDto request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }
}
