package com.fastcampus.boardadminproject.controller;

import com.fastcampus.boardadminproject.dto.response.ArticleResponse;
import com.fastcampus.boardadminproject.service.ArticleManagementService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/management/articles")
@Controller
public class ArticleManagementController {

    private final ArticleManagementService articleManagementService;

    @GetMapping
    public String articles(Model model) {
        model.addAttribute(
                "articles",
                articleManagementService.getArticles().stream().map(ArticleResponse::withoutContent).toList()
        );

        return "management/articles";
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ArticleResponse article(@PathVariable Long id) {
        return ArticleResponse.withContent(articleManagementService.getArticle(id));
    }

    @PostMapping("/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleManagementService.deleteArticle(id);

        return "redirect:/management/articles";
    }
}
