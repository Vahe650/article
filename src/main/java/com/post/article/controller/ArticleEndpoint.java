package com.post.article.controller;

import com.post.article.dto.ArticleDto;
import com.post.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleEndpoint {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleDto> getAll(@RequestParam int page, @RequestParam int size) {
        return articleService.findAll(PageRequest.of(page, size));
    }

    @PostMapping
    public void save(@Valid @RequestBody ArticleDto articleDto) {
        articleService.save(articleDto);
    }
}
