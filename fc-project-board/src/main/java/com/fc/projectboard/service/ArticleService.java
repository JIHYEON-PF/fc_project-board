package com.fc.projectboard.service;

import com.fc.projectboard.domain.type.SearchType;
import com.fc.projectboard.dto.ArticleDto;
import com.fc.projectboard.dto.ArticleWithCommentsDto;
import com.fc.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(Long articleId) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
        // TODO document why this method is empty
    }

    public void updateArticle(ArticleDto dto) {
        // TODO document why this method is empty
    }

    public void deleteArticle(long articleId) {
        // TODO document why this method is empty
    }
}
