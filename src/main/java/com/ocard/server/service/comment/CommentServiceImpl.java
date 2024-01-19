package com.ocard.server.service.comment;

import com.ocard.server.dto.comment.CreateCommentDTO;
import com.ocard.server.dto.comment.UpdateCommentDTO;
import com.ocard.server.mapper.comment.CommentMapper;
import com.ocard.server.model.comment.Comment;
import com.ocard.server.repository.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Integer commentId) throws NoSuchElementException {
        Optional<Comment> commentExisting = commentRepository.findById(commentId);
        return commentExisting.get();
    }

    @Override
    public Comment createComment(Integer articleId,
                                 CreateCommentDTO createCommentDTO) {
        Comment comment = commentMapper.createCommentDTOtoComment(createCommentDTO);
        comment.setDatePosted(LocalDateTime.now());
        comment.setArticleId(articleId);
        return commentRepository.save(comment);
    }


    @Override
    public Comment updateComment(Integer commentId,
                                 UpdateCommentDTO updateCommentDTO) throws NoSuchElementException {
        Optional<Comment> commentExisting = commentRepository.findById(commentId);
        Comment comment = commentMapper.updateCommentDTOtoComment(updateCommentDTO);
        comment.setCommentId(commentId);
        comment.setArticleId(commentExisting.get().getArticleId());
        comment.setDatePosted(commentExisting.get().getDatePosted());
        comment.setDateUpdated(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public String deleteComment(Integer commentId) throws NoSuchElementException {
        Optional<Comment> commentExisting = commentRepository.findById(commentId);
        commentRepository.deleteById(commentExisting.get().getCommentId());
        return "Delete commentId success.";
    }

}
