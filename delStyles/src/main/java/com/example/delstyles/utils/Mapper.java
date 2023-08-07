package com.example.delstyles.utils;

import com.example.delstyles.dtos.response.CommentResponseDto;
import com.example.delstyles.dtos.response.DesignResponseDto;
import com.example.delstyles.dtos.response.UserResponseDto;
import com.example.delstyles.entities.Comment;
import com.example.delstyles.entities.Design;
import com.example.delstyles.entities.User;

import java.time.LocalDateTime;

public class Mapper {

    public static UserResponseDto createNewUser(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    public static UserResponseDto loginUser(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    public static DesignResponseDto createNewDesign(Design design){
        return DesignResponseDto.builder()
                .designTitle(design.getTitle())
                .description(design.getDescription())
                .gender(design.getGender())
                .imageUrl(design.getImageUrl())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static DesignResponseDto findDesignByTitle(Design design) {
        return DesignResponseDto.builder()
                .designTitle(design.getTitle())
                .description(design.getDescription())
                .gender(design.getGender())
                .imageUrl(design.getImageUrl())
                .createdAt(LocalDateTime.now())
                .build();
    }


    public static CommentResponseDto commentOnPost(Comment comment) {
        return CommentResponseDto.builder()
                .username(comment.getUser().getUsername())
                .comment(comment.getComment())
                .designTitle(comment.getDesign().getTitle())
                .createdAt(comment.getCreatedAt())
                .build();
    }


}
