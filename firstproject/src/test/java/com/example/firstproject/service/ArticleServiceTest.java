package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅된다
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());

    }

    @Test
    void show_성공__존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");

        //실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패__존재하지_않은_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;

        //실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected, article); // null은 toString으로 나타낼 수 없다
    }

    @Test
    @Transactional
    void create_성공__title과_content만_있는_dto_입력() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        //실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패__id가_포함된_dto_입력() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        //실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void updatae_성공__존재하는_id와_title_content가_있는_dto_입력() {
        // 예상
        Long id = 1L;
        String title = "티라노";
        String content = "크와아아왕";
        ArticleForm dto = new ArticleForm(1L, title, content);
        Article expected = new Article(1L, title, content);;

        //실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void updatae_성공__존재하는_id와_title만_있는_dto_입력() {
        // 예상
        Long id = 2L;
        String title = "브라키오";
        ArticleForm dto = new ArticleForm(2L, title, "2222");
        Article expected = new Article(2L, title, "2222");

        //실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void updatae_실패__존재하지_않은_id의_dto_입력() {
        // 예상
        Long id = -1L;
        String title = "트리케라";
        String content = "뿌에에엥";
        ArticleForm dto = new ArticleForm(-1L, title, content);
        Article expected = null;

        //실제
        Article article = articleService.update(id, dto);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void delete_성공__존재하는_id_입력() {
        // 예상
        Long id = 3L;
        Article expected = new Article(id, "다다다다", "3333");

        //실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void delete_실패__존재하지_않은_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;

        //실제
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected, article);
    }
}
