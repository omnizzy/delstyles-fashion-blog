package com.example.delstyles.dtos.request;

import com.example.delstyles.enums.UserType;
import lombok.*;

import javax.management.relation.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    private String username;

    private String password;

    private UserType userType;
}
