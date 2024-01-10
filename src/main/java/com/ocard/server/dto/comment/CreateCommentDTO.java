package com.ocard.server.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCommentDTO {

    @NotBlank
    private String commentContent;

    private LocalDateTime datePosted;

    private Integer articleId;

}
