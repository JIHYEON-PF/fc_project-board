package com.fc.projectboard.service;

import com.fc.projectboard.dto.ArticleCommentDto;
import com.fc.projectboard.repository.ArticleCommentRepository;
import com.fc.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(Long articleId) {
        return List.of();
    }
}
