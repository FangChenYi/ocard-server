package com.ocard.server.mapper.comment;

import com.ocard.server.dto.comment.CreateCommentDTO;
import com.ocard.server.dto.comment.UpdateCommentDTO;
import com.ocard.server.model.comment.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment createCommentDTOtoComment(CreateCommentDTO createCommentDTO);

    Comment updateCommentDTOtoComment(UpdateCommentDTO updateCommentDTO);
}
