package com.example.springbootnewsportal.service;

import com.example.springbootnewsportal.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Page<Comment> getCommentsForNews(Long newsId, Pageable pageable);

    long countCommentsForNews(Long newsId);
}
