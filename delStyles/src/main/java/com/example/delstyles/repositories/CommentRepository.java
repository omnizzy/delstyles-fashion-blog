package com.example.delstyles.repositories;


import com.example.delstyles.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

    Optional<Comment> findCommentById(Long id);
}
