package com.example.springbootnewsportal.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.springbootnewsportal.service.NewsService;

@Controller
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @PostMapping("/news/{id}/delete")
    public String delete(@PathVariable Long id) {
        newsService.deleteById(id);
        return "redirect:/news/";
    }

    @GetMapping("news/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("news", newsService.findById(id));
        return "news";
    }
}
