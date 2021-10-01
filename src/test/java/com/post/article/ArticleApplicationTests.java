package com.post.article;

import com.post.article.dto.ArticleDto;
import com.post.article.entity.Article;
import com.post.article.mapper.ArticleEntityMapper;
import com.post.article.repository.ArticleRepository;
import com.post.article.service.impl.ArticleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.*;

@SpringBootTest
@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
public class ArticleApplicationTests {

    @InjectMocks
    ArticleServiceImpl articleService;

    @Mock
    ArticleRepository articleRepository;

    @Mock
    private Pageable pageableMock;

    @Spy
    ArticleEntityMapper articleEntityMapper = Mappers.getMapper(ArticleEntityMapper.class);


    @Before
    public void init() {
        articleService = new ArticleServiceImpl(articleRepository, articleEntityMapper);
    }

    @Test
    public void test_createArticle() {
        LocalDate publicationDate = LocalDate.of(2019, Month.APRIL, 22);
        ArticleDto articleDto = new ArticleDto(1L, "some title", "John", "some content", publicationDate);
        articleService.save(articleDto);
        verify(articleRepository, times(1)).save(articleEntityMapper.toEntity(articleDto));
    }

    @Test
    public void  test_getAllArticlesByPage() {
        List<Article> list = new ArrayList<>();
        Article empOne = new Article(1L, "some title1", "John", "some content1", LocalDate.now().minus(Period.ofDays(1)));
        Article empTwo = new Article(2L, "some title2", "Tim", "some content2", LocalDate.now().minus(Period.ofDays(3)));
        Article empThree = new Article(3L, "some title3", "Ben", "some content3", LocalDate.now().minus(Period.ofDays(2)));

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        Page<Article> articlePage =new PageImpl<>(list, pageableMock, list.size());
        when(articleRepository.findAll(pageableMock)).thenReturn(articlePage);
        List<ArticleDto> all = articleService.findAll(pageableMock);
        assertEquals(articlePage.getSize(),all.size());
    }

}
