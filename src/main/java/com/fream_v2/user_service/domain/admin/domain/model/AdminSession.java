package com.fream_v2.user_service.domain.admin.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 관리자 세션 정보
 */
@Getter
@Builder
public class AdminSession {
    private final Long sessionId;
    private final Long adminId;
    private final String sessionToken;
    private final String ipAddress;
    private final String userAgent;
    private final LocalDateTime createdAt;
    private final LocalDateTime lastAccessedAt;
    private final LocalDateTime expiresAt;
    private final boolean twoFactorVerified;

    /**
     * 세션 생성
     */
    public static AdminSession createSession(Long adminId, String sessionToken,
                                             String ipAddress, String userAgent,
                                             boolean twoFactorRequired) {
        LocalDateTime now = LocalDateTime.now();
        return AdminSession.builder()
                .adminId(adminId)
                .sessionToken(sessionToken)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .createdAt(now)
                .lastAccessedAt(now)
                .expiresAt(now.plusHours(2)) // 2시간 후 만료
                .twoFactorVerified(!twoFactorRequired)
                .build();
    }

    /**
     * 세션 갱신
     */
    public AdminSession refresh() {
        return AdminSession.builder()
                .sessionId(this.sessionId)
                .adminId(this.adminId)
                .sessionToken(this.sessionToken)
                .ipAddress(this.ipAddress)
                .userAgent(this.userAgent)
                .createdAt(this.createdAt)
                .lastAccessedAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusHours(2))
                .twoFactorVerified(this.twoFactorVerified)
                .build();
    }

    /**
     * 2차 인증 완료
     */
    public AdminSession verify2FA() {
        return AdminSession.builder()
                .sessionId(this.sessionId)
                .adminId(this.adminId)
                .sessionToken(this.sessionToken)
                .ipAddress(this.ipAddress)
                .userAgent(this.userAgent)
                .createdAt(this.createdAt)
                .lastAccessedAt(LocalDateTime.now())
                .expiresAt(this.expiresAt)
                .twoFactorVerified(true)
                .build();
    }

    /**
     * 세션 유효성 확인
     */
    public boolean isValid() {
        return LocalDateTime.now().isBefore(this.expiresAt);
    }

    /**
     * 세션 만료 여부
     */
    public boolean isExpired() {
        return !isValid();
    }
}
