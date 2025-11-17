package com.fream_v2.user_service.domain.admin.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 관리자 2차 인증 설정 엔티티
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("admin_two_factor_auth")
public class AdminTwoFactorAuthEntity {
    @Id
    private Long id;
    private Long adminId;
    private String secretKey; // TOTP Secret Key (암호화 저장)
    private Boolean isEnabled;
    private String backupCodes; // JSON 배열로 저장 (암호화)
    private LocalDateTime enabledAt;
    private LocalDateTime lastUsedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * 2차 인증 설정 생성
     */
    public static AdminTwoFactorAuthEntity create(Long adminId, String secretKey, String backupCodes) {
        LocalDateTime now = LocalDateTime.now();
        return AdminTwoFactorAuthEntity.builder()
                .adminId(adminId)
                .secretKey(secretKey)
                .isEnabled(false) // 초기에는 비활성화
                .backupCodes(backupCodes)
                .createdAt(now)
                .updatedAt(now)
                .build();
    }

    /**
     * 2차 인증 활성화
     */
    public AdminTwoFactorAuthEntity enable() {
        return AdminTwoFactorAuthEntity.builder()
                .id(this.id)
                .adminId(this.adminId)
                .secretKey(this.secretKey)
                .isEnabled(true)
                .backupCodes(this.backupCodes)
                .enabledAt(LocalDateTime.now())
                .lastUsedAt(this.lastUsedAt)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 2차 인증 사용 시간 업데이트
     */
    public AdminTwoFactorAuthEntity updateLastUsed() {
        return AdminTwoFactorAuthEntity.builder()
                .id(this.id)
                .adminId(this.adminId)
                .secretKey(this.secretKey)
                .isEnabled(this.isEnabled)
                .backupCodes(this.backupCodes)
                .enabledAt(this.enabledAt)
                .lastUsedAt(LocalDateTime.now())
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
