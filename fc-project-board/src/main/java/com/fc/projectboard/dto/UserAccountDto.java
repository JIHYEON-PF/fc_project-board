package com.fc.projectboard.dto;

import com.fc.projectboard.domain.UserAccount;

import java.time.LocalDateTime;

public record UserAccountDto (
        Long id,
        String userId,
        String userPassword,
        String email,
        String nickname,
        String memo,
        LocalDateTime createAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static UserAccountDto of(Long id, String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(id, userId, userPassword, email, nickname, memo, createAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getId(),
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                userId,
                userPassword,
                email,
                nickname,
                memo
        );
    }
}
