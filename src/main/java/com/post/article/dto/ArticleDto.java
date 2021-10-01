package com.post.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {


    private Long id;
    private String title;
    private String author;
    private String content;

    private LocalDate publicationDate;

}

