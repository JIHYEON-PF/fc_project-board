package com.fc.projectboard.dto.response;

import com.fc.projectboard.dto.ArticleCommentDto;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public record ArticleCommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        String email,
        String nickname
) {

    public static ArticleCommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String nickname) {
        return new ArticleCommentResponse(id, content, createdAt, email, nickname);
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto) {
        String nickname = StringUtils.isBlank(dto.userAccountDto().nickname())
                ? dto.userAccountDto().userId()
                : dto.userAccountDto().nickname();

        return new ArticleCommentResponse(
                dto.id(),
                dto.content(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                nickname
        );
    }
}
