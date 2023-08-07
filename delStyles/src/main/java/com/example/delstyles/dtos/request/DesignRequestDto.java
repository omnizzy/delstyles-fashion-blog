package com.example.delstyles.dtos.request;

import com.example.delstyles.entities.User;
import com.example.delstyles.enums.Category;
import com.example.delstyles.enums.Gender;
import com.example.delstyles.enums.Reaction;
import com.example.delstyles.enums.UserType;
import lombok.*;

import javax.management.relation.Role;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesignRequestDto {

    @NotBlank(message = "please enter your admin username")
    private  String username;

    @NotBlank(message = "Please enter the design title")
    private String designTitle;

    @NotBlank(message = "Please enter design description")
    private String description;

    @NotBlank(message = "Please select a gender")
    private Gender gender;

    @NotBlank(message = "Please select a category")
    private Category category;

//    @NotBlank(message = "Please enter the design image link")
//    private String imageUrl;

}
