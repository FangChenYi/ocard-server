package com.ocard.server.service.comment;

import com.ocard.server.dto.comment.CreateCommentDTO;
import com.ocard.server.dto.comment.UpdateCommentDTO;
import com.ocard.server.model.comment.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();

    Comment getCommentById(Integer commentId);

    Comment createComment(Integer articleId, CreateCommentDTO createCommentDTO);

    Comment updateComment(Integer commentId, UpdateCommentDTO updateCommentDTO);

    String deleteComment(Integer commentId);

}
