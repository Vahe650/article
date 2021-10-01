package com.post.article.mapper;


import com.post.article.dto.ArticleDto;
import com.post.article.entity.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleEntityMapper extends EntityMapper<ArticleDto, Article> {
}
