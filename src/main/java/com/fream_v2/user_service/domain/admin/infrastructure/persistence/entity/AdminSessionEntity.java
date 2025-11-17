package com.fream_v2.user_service.domain.admin.infrastructure.persistence.entity;

import com.fream_v2.user_service.domain.admin.domain.model.AdminSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 관리자 세션 엔티티
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("admin_sessions")
public class AdminSessionEntity {
    @Id
    private Long id;
    private Long adminId;
    private String sessionToken;
    private String ipAddress;
    private String userAgent;
    private LocalDateTime createdAt;
    private LocalDateTime lastAccessedAt;
    private LocalDateTime expiresAt;
    private Boolean twoFactorVerified;

    /**
     * 도메인 모델로 변환
     */
    public AdminSession toDomain() {
        return AdminSession.builder()
                .sessionId(this.id)
                .adminId(this.adminId)
                .sessionToken(this.sessionToken)
                .ipAddress(this.ipAddress)
                .userAgent(this.userAgent)
                .createdAt(this.createdAt)
                .lastAccessedAt(this.lastAccessedAt)
                .expiresAt(this.expiresAt)
                .twoFactorVerified(this.twoFactorVerified != null ? this.twoFactorVerified : false)
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 생성 (신규)
     */
    public static AdminSessionEntity fromDomain(AdminSession session) {
        return AdminSessionEntity.builder()
                .adminId(session.getAdminId())
                .sessionToken(session.getSessionToken())
                .ipAddress(session.getIpAddress())
                .userAgent(session.getUserAgent())
                .createdAt(session.getCreatedAt())
                .lastAccessedAt(session.getLastAccessedAt())
                .expiresAt(session.getExpiresAt())
                .twoFactorVerified(session.isTwoFactorVerified())
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 업데이트 (기존 ID 포함)
     */
    public static AdminSessionEntity updateFromDomain(AdminSession session) {
        return AdminSessionEntity.builder()
                .id(session.getSessionId())
                .adminId(session.getAdminId())
                .sessionToken(session.getSessionToken())
                .ipAddress(session.getIpAddress())
                .userAgent(session.getUserAgent())
                .createdAt(session.getCreatedAt())
                .lastAccessedAt(session.getLastAccessedAt())
                .expiresAt(session.getExpiresAt())
                .twoFactorVerified(session.isTwoFactorVerified())
                .build();
    }
}
