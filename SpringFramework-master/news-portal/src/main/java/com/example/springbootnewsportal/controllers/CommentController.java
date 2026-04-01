package com.example.springbootnewsportal.controllers;

import com.example.springbootnewsportal.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springbootnewsportal.service.CommentService;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/news/{id}/comments")
    public String listComments(
            @PathVariable("id") Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createDate").descending());
        Page<Comment> comments = commentService.getCommentsForNews(id, pageable);
        model.addAttribute("comments", comments);
        model.addAttribute("totalComments", commentService.countCommentsForNews(id));
        model.addAttribute("newsId", id);
        return "comments";
    }
}