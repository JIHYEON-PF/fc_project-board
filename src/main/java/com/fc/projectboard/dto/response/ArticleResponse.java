package com.fc.projectboard.dto.response;

import com.fc.projectboard.dto.ArticleDto;
import com.fc.projectboard.dto.HashtagDto;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record ArticleResponse (
    Long id,
    String title,
    String content,
    Set<String> hashtags,
    LocalDateTime createdAt,
    String email,
    String nickname
) {

    public static ArticleResponse of(Long id, String title, String content, Set<String> hashtags, LocalDateTime createdAt, String email, String nickname) {
        return new ArticleResponse(id, title, content, hashtags, createdAt, email, nickname);
    }

    public static ArticleResponse from(ArticleDto dto) {
        String nickname = StringUtils.isEmpty(dto.userAccountDto().nickname())
                ? dto.userAccountDto().userId()
                : dto.userAccountDto().nickname();

        return new ArticleResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtagDtos().stream()
                        .map(HashtagDto::hashtagName)
                        .collect(Collectors.toUnmodifiableSet()),
                dto.createdAt(),
                dto.userAccountDto().email(),
                nickname
        );
    }
}
