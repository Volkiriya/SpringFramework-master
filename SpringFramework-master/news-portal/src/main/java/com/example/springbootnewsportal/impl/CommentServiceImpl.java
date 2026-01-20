package com.example.springbootnewsportal.impl;

import com.example.springbootnewsportal.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.springbootnewsportal.repository.CommentRepository;
import com.example.springbootnewsportal.service.CommentService;
import com.example.springbootnewsportal.service.NewsService;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl  implements CommentService {
    private final CommentRepository commentRepository;
    private final NewsService newsService;

    @Override
    public long countCommentsForNews(Long newsId) {
        newsService.findById(newsId);
        return commentRepository.countByNewsId(newsId);
    }

    @Override
    public Page<Comment> getCommentsForNews(Long newsId, Pageable pageable) {
        newsService.findById(newsId);
        return commentRepository.findByNewsId(newsId, pageable);
    }
}
