package com.fream_v2.user_service.domain.admin.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 관리자 IP 화이트리스트 엔티티
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("admin_ip_whitelist")
public class AdminIpWhitelistEntity {
    @Id
    private Long id;
    private String ipAddress;
    private String description;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private Long createdBy; // 생성한 관리자 ID
    private LocalDateTime updatedAt;

    /**
     * IP 화이트리스트 생성
     */
    public static AdminIpWhitelistEntity create(String ipAddress, String description, Long createdBy) {
        return AdminIpWhitelistEntity.builder()
                .ipAddress(ipAddress)
                .description(description)
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .createdBy(createdBy)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 활성화 상태 변경
     */
    public AdminIpWhitelistEntity changeActiveStatus(boolean isActive) {
        return AdminIpWhitelistEntity.builder()
                .id(this.id)
                .ipAddress(this.ipAddress)
                .description(this.description)
                .isActive(isActive)
                .createdAt(this.createdAt)
                .createdBy(this.createdBy)
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
