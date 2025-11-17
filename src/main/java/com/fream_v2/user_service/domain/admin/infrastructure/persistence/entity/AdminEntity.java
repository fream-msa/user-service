package com.fream_v2.user_service.domain.admin.infrastructure.persistence.entity;

import com.fream_v2.user_service.domain.admin.domain.model.Admin;
import com.fream_v2.user_service.domain.admin.domain.model.AdminRole;
import com.fream_v2.user_service.domain.admin.domain.model.AdminStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 관리자 엔티티 (Infrastructure Layer)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("admins")
public class AdminEntity {
    @Id
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role; // AdminRole enum을 String으로 저장
    private String status; // AdminStatus enum을 String으로 저장
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;

    /**
     * 도메인 모델로 변환
     */
    public Admin toDomain() {
        return Admin.builder()
                .adminId(this.id)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .role(AdminRole.valueOf(this.role))
                .status(AdminStatus.valueOf(this.status))
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .lastLoginAt(this.lastLoginAt)
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 생성 (신규)
     */
    public static AdminEntity fromDomain(Admin admin) {
        return AdminEntity.builder()
                .username(admin.getUsername())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .role(admin.getRole().name())
                .status(admin.getStatus().name())
                .createdAt(admin.getCreatedAt())
                .updatedAt(admin.getUpdatedAt())
                .lastLoginAt(admin.getLastLoginAt())
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 업데이트 (기존 ID 포함)
     */
    public static AdminEntity updateFromDomain(Admin admin) {
        return AdminEntity.builder()
                .id(admin.getAdminId())
                .username(admin.getUsername())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .role(admin.getRole().name())
                .status(admin.getStatus().name())
                .createdAt(admin.getCreatedAt())
                .updatedAt(admin.getUpdatedAt())
                .lastLoginAt(admin.getLastLoginAt())
                .build();
    }
}
