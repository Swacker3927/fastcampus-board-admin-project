package com.fastcampus.boardadminproject.dto.response;

import com.fastcampus.boardadminproject.domain.constant.*;
import com.fastcampus.boardadminproject.dto.AdminAccountDto;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public record AdminAccountResponse(
        String userId,
        String userPassword,
        String roleTypes,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy
) {
    public static AdminAccountResponse of(String userId, String userPassword, String roleTypes, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy) {
        return new AdminAccountResponse(userId, userPassword, roleTypes, email, nickname, memo, createdAt, createdBy);
    }

    public static AdminAccountResponse from(AdminAccountDto dto) {
        return AdminAccountResponse.of(
                dto.userId(),
                dto.userPassword(),
                dto.roleTypes().stream()
                        .map(RoleType::getDescription)
                        .collect(Collectors.joining(", ")),
                dto.email(),
                dto.nickname(),
                dto.memo(),
                dto.createdAt(),
                dto.createdBy()
        );
    }
}
