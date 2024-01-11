package com.ocard.server.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateCommentDTO {

    @NotBlank
    private String commentContent;

    private LocalDateTime dateUpdated;

}
