package com.ocard.server.controller.comment;

import com.ocard.server.dto.comment.CreateCommentDTO;
import com.ocard.server.dto.comment.UpdateCommentDTO;
import com.ocard.server.model.comment.Comment;
import com.ocard.server.service.comment.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comment/{commentId}")
    public Comment getCommentById(@PathVariable Integer commentId) {
        return commentService.getCommentById(commentId);
    }

    @PostMapping("/comment/{articleId}")
    public Comment createComment(@PathVariable Integer articleId,
                                 @RequestBody @Valid CreateCommentDTO createCommentDTO) {
        return commentService.createComment(articleId, createCommentDTO);
    }

    @PutMapping("/comment/{commentId}")
    public Comment updateComment(@PathVariable Integer commentId,
                                 @RequestBody @Valid UpdateCommentDTO updateCommentDTO) {
        return commentService.updateComment(commentId, updateCommentDTO);
    }

    @DeleteMapping("/comment/{commentId}")
    public String deleteComment(@PathVariable Integer commentId) {
        return commentService.deleteComment(commentId);
    }


}
