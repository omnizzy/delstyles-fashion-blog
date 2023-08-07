package com.example.delstyles.controllers;


import com.example.delstyles.dtos.request.CommentRequestDto;
import com.example.delstyles.dtos.request.DeleteCommentRequestDto;
import com.example.delstyles.dtos.response.CommentResponseDto;
import com.example.delstyles.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/delstyles")
public class CommentController {

    private final CommentService commentService;

    private final HttpSession session;


    @PostMapping(path="/createcomment")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody @Valid CommentRequestDto request){
        return ResponseEntity.ok(commentService.createComment(request, (String) session.getAttribute("username")));
    }

    @DeleteMapping("/deletecomment/{id}")
    public ResponseEntity<String> deleteCommentById(@RequestBody DeleteCommentRequestDto request, @PathVariable Long id) {
        String result = commentService.deleteCommentById(request, id);
        return ResponseEntity.ok(result);
    }

}
