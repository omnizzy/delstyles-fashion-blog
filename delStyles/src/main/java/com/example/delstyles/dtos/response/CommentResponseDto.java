package com.example.delstyles.dtos.response;

import com.example.delstyles.enums.Reaction;
import com.example.delstyles.enums.UserType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class CommentResponseDto {

    private String username;

    private String designTitle;

    private String comment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
