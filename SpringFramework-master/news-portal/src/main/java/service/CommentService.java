package service;

import entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<Comment> getCommentsForNews(Long id, Pageable pageable);
    long countCommentsForNews(Long id);
}
