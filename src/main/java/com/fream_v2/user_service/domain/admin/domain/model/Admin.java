package com.fream_v2.user_service.domain.admin.domain.model;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

/**
 * 관리자 도메인 모델
 */
@Getter
@Builder
public class Admin {
    private final Long adminId;
    private final String username;
    private final String email;
    private final String password;
    private final AdminRole role;
    private final AdminStatus status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final LocalDateTime lastLoginAt;

    /**
     * 관리자 생성
     */
    public static Admin createAdmin(String username, String email, String password, AdminRole role) {
        return Admin.builder()
                .username(username)
                .email(email)
                .password(password)
                .role(role)
                .status(AdminStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 로그인 시간 업데이트
     */
    public Admin updateLastLogin() {
        return Admin.builder()
                .adminId(this.adminId)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .role(this.role)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .lastLoginAt(LocalDateTime.now())
                .build();
    }

    /**
     * 권한 확인
     */
    public boolean hasPermission(AdminPermission permission) {
        return this.role.hasPermission(permission);
    }

    /**
     * 마스터 권한 확인
     */
    public boolean isMaster() {
        return this.role == AdminRole.MASTER;
    }
}