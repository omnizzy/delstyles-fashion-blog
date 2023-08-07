package com.example.delstyles.dtos.response;

import com.example.delstyles.enums.Gender;
import com.example.delstyles.enums.Reaction;
import com.example.delstyles.enums.UserType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesignResponseDto {


    private String designTitle;

    private String description;

    private Gender gender;

    private String imageUrl;

    private LocalDateTime createdAt;

}
