package com.fc.projectboard.service;

import com.fc.projectboard.domain.Article;
import com.fc.projectboard.domain.type.SearchType;
import com.fc.projectboard.dto.ArticleDto;
import com.fc.projectboard.dto.ArticleWithCommentsDto;
import com.fc.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        if (StringUtils.isEmpty(searchKeyword)) {
            return articleRepository.findAll(pageable).map(ArticleDto::from);
        }

        return switch (searchType) {
            case TITLE    -> articleRepository.findByTitleContaining(searchKeyword, pageable).map(ArticleDto::from);
            case CONTENT  -> articleRepository.findByContentContaining(searchKeyword, pageable).map(ArticleDto::from);
            case ID       -> articleRepository.findByUserAccount_UserIdContaining(searchKeyword, pageable).map(ArticleDto::from);
            case NICKNAME -> articleRepository.findByUserAccount_NicknameContaining(searchKeyword, pageable).map(ArticleDto::from);
            case HASHTAG  -> articleRepository.findByHashtag("#" + searchKeyword, pageable).map(ArticleDto::from);
        };

    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(Long articleId) {
        return articleRepository.findById(articleId).map(ArticleWithCommentsDto::from)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 없습니다 - articleId: " + articleId));
    }

    public void saveArticle(ArticleDto dto) {
        articleRepository.save(dto.toEntity());
    }

    public void updateArticle(ArticleDto dto) {
        try {
            Article article = articleRepository.getReferenceById(dto.id());
            if (StringUtils.isNotEmpty(dto.title()))
                article.setTitle(dto.title());
            if (StringUtils.isNotEmpty(dto.content()))
                article.setContent(dto.content());
            article.setHashtag(dto.hashtag());
        } catch (EntityNotFoundException e) {
            log.warn("Article update was failed by article is not found - dto: {}", dto);
        }
    }

    public void deleteArticle(long articleId) {
        articleRepository.deleteById(articleId);
    }

    public long getArticleCount() {
        return articleRepository.count();
    }

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticlesViaHashtag(String hashtag, Pageable pageable) {
        if (StringUtils.isEmpty(hashtag)) {
            return Page.empty(pageable);
        }

        return articleRepository.findByHashtag(hashtag, pageable).map(ArticleDto::from);
    }

    @Transactional(readOnly = true)
    public List<String> getHashtags() {
        return articleRepository.findAllDistinctHashtags();
    }
}
