package com.fc.projectboard.controller;

import com.fc.projectboard.dto.UserAccountDto;
import com.fc.projectboard.dto.request.ArticleCommentRequest;
import com.fc.projectboard.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @PostMapping("/new")
    public String postNewArticleComment(ArticleCommentRequest articleCommentRequest) {

        // TODO : 인증정보 필요
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(UserAccountDto.of(
                "fkaa", "asdf1234", "fkaa@mail.com", "fkaa", "memeo"
        )));

        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping("/{commentId}/delete")
    public String deleteArticleComment(@PathVariable Long commentId, Long articleId) {
        articleCommentService.deleteArticleComment(commentId);

        return "redirect:/articles/" + articleId;
    }
}
