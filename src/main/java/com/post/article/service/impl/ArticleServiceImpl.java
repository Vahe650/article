package com.post.article.service.impl;

import com.post.article.dto.ArticleDto;
import com.post.article.entity.Article;
import com.post.article.mapper.ArticleEntityMapper;
import com.post.article.repository.ArticleRepository;
import com.post.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;


    @Override
    public List<ArticleDto> findAll(Pageable pageable) {
        List<Article> articles = articleRepository.findAll(pageable).getContent();
        return articleEntityMapper.toDto(articles);
    }

    @Override
    public void save(ArticleDto articleDto) {
        Article article = articleEntityMapper.toEntity(articleDto);
        articleRepository.save(article);
    }

    @Override
    public Long countOfLastWeek() {
        return articleRepository.countOfLastWeek();
    }
}
