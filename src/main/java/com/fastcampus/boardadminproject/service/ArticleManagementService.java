package com.fastcampus.boardadminproject.service;

import com.fastcampus.boardadminproject.dto.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManagementService {
    public List<ArticleDto> getArticles() {
        return List.of();
    }

    public ArticleDto getArticle(Long articleId) {
        return null;
    }

    public void deleteArticle(Long articleId) {

    }
}
