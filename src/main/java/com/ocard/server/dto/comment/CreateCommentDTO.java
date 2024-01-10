package com.ocard.server.dto.comment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCommentDTO {

    private String commentContent;

    private LocalDateTime datePosted;

    private Integer articleId;

}
