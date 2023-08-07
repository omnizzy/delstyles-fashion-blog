package com.example.delstyles.services.Implementations;

import com.example.delstyles.dtos.request.CommentRequestDto;
import com.example.delstyles.dtos.request.DeleteCommentRequestDto;
import com.example.delstyles.dtos.response.CommentResponseDto;
import com.example.delstyles.entities.Comment;
import com.example.delstyles.entities.Design;
import com.example.delstyles.entities.User;
import com.example.delstyles.enums.UserType;
import com.example.delstyles.exceptions.InvalidDataException;
import com.example.delstyles.repositories.CommentRepository;
import com.example.delstyles.repositories.DesignRepository;
import com.example.delstyles.repositories.UserRepository;
import com.example.delstyles.services.CommentService;
import com.example.delstyles.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final DesignRepository designRepository;
    private final HttpSession session;

    @Override
    public CommentResponseDto createComment(CommentRequestDto request, String username) {

        Optional<Design> design = designRepository.findDesignByTitle(request.getDesignTitle());
        if(design.isEmpty()){
            throw new InvalidDataException("Post does not exist");
        }

        Optional<User> user = userRepository.findByUsername(username);
        User newUser;
        if (user.isEmpty()) {
            newUser = new User();
            newUser.setPassword("1234");
            newUser.setUserType(UserType.VISITOR);
            newUser.setUsername(request.getUsername());
            userRepository.save(newUser);
            session.setAttribute("username", newUser.getUsername());
        } else {
            newUser = user.get();
        }

        Comment comment = new Comment();
        comment.setUser(newUser);
        comment.setDesign(design.get());
        comment.setComment(request.getComment());
        comment.setCreatedAt(LocalDateTime.now());

        Comment newComment = commentRepository.save(comment);

        return Mapper.commentOnPost(newComment);

    }

    @Override
    public CommentResponseDto editCommentById(CommentRequestDto request, Long id) {
        return null;
    }

    @Override
    public String deleteCommentById(DeleteCommentRequestDto request, Long id) {

        Optional<Comment> comment = commentRepository.findCommentById(request.getCommentId());
        if(comment.isEmpty()){
            throw new InvalidDataException("Comment does not exist");
        }

        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if(user.isPresent()){
            commentRepository.delete(comment.get());
            return "Comment successfully deleted";
        }

        throw new InvalidDataException("You are unauthorized to delete this comment");

    }
}
