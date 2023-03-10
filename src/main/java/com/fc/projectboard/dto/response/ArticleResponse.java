package com.fc.projectboard.dto.response;

import com.fc.projectboard.dto.ArticleDto;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public record ArticleResponse (
    Long id,
    String title,
    String content,
    String hashtag,
    LocalDateTime createdAt,
    String email,
    String nickname
) {

    public static ArticleResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String nickname) {
        return new ArticleResponse(id, title, content, hashtag, createdAt, email, nickname);
    }

    public static ArticleResponse from(ArticleDto dto) {
        String nickname = StringUtils.isEmpty(dto.userAccountDto().nickname())
                ? dto.userAccountDto().userId()
                : dto.userAccountDto().nickname();

        return new ArticleResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                nickname
        );
    }
}
