package com.post.article.service;

import com.post.article.dto.ArticleDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    List<ArticleDto> findAll(Pageable pageable);

    void save(ArticleDto articleDto);

    Long countOfLastWeek();

}
