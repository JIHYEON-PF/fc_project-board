package com.fc.projectboard.repository.querydsl;

import com.fc.projectboard.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface ArticleRepositoryCustom {

    /**
     * @Deprecated 해시태그 도메인을 새로 만들었으므로 게시글의 해시코드를 조회하는 Query는 불필요
     * @see HashtagRepositoryCustom#findAllHashtagNames()
     */
    @Deprecated
    List<String> findAllDistinctHashtags();

    Page<Article> findByHashtagNames(Collection<String> hashtagName, Pageable pageable);
}
