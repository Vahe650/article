package com.post.article.repository;

import com.post.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "select count(a) from articles a where  a.publication_date >= NOW() - INTERVAL '1 WEEK' and a.publication_date <= NOW()", nativeQuery = true)
    Long countOfLastWeek();

}
