package com.ocard.server.repository.comment;

import com.ocard.server.model.comment.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
