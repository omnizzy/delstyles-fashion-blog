package com.example.delstyles.dtos.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCommentRequestDto {

    private Long commentId;

    @NotEmpty(message = "Please provide a username to comment on this design")
    private  String username;

    private String designTitle;

    private String comment;

}
