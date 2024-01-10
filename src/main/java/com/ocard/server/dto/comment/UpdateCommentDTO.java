package com.ocard.server.dto.comment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateCommentDTO {

    private String commentContent;

    private LocalDateTime dateUpdated;

}
