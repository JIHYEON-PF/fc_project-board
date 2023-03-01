package com.fc.projectboard.service;

import com.fc.projectboard.domain.Article;
import com.fc.projectboard.dto.ArticleCommentDto;
import com.fc.projectboard.repository.ArticleCommentRepository;
import com.fc.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleRepository articleRepository;
    @Mock private ArticleCommentRepository articleCommentRepository;

    @DisplayName("게시글 아이디를 통한 게시글 댓글 조회")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsArticleComments() throws Exception {
        //given
        Long articleId = 1L;
        given(articleRepository.findById(articleId))
                .willReturn(Optional.of(Article.of(null, "title", "content", "hashtag")));

        //when
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);

        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("댓글 정보를 입력하면, 댓글을 저장")
    @Test
    void given_whenSearchingArticleComments_thenReturnsArticleComments() throws Exception {
        //given
        Long articleId = 1L;
        given(articleRepository.findById(articleId))
                .willReturn(Optional.of(Article.of( null, "title", "content", "hashtag")));

        //when
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);

        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

}