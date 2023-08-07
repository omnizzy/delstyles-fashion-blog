package com.example.delstyles.entities;

import com.example.delstyles.enums.Reaction;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private Reaction reaction;

    @ManyToOne
    @JoinColumn(name = "design_title", referencedColumnName = "title")
    private Design design;

    @ManyToOne
    @JoinColumn(name = "comment", referencedColumnName = "comment")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}
