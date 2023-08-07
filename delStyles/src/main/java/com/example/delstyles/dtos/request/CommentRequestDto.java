package com.example.delstyles.dtos.request;

import com.example.delstyles.enums.Reaction;
import lombok.*;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {

    @NotEmpty(message = "Please provide a username to comment on this design")
    private  String username;

    private String designTitle;

    private String comment;

}
