package com.post.article.controller;

import com.post.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminEndpoint {

    private final ArticleService articleService;

    @GetMapping("/statistics")
    public Long getStatistics() {
        return articleService.countOfLastWeek();
    }
}
