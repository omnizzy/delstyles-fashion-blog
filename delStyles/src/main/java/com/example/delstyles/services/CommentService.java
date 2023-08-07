package com.example.delstyles.services;

import com.example.delstyles.dtos.request.CommentRequestDto;
import com.example.delstyles.dtos.request.DeleteCommentRequestDto;
import com.example.delstyles.dtos.response.CommentResponseDto;

public interface CommentService {

    CommentResponseDto createComment(CommentRequestDto request, String username);

    CommentResponseDto editCommentById(CommentRequestDto request, Long id);

    String deleteCommentById(DeleteCommentRequestDto request, Long id);
}
