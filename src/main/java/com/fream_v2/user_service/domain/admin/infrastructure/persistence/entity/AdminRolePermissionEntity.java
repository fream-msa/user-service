package com.fream_v2.user_service.domain.admin.infrastructure.persistence.entity;


import com.fream_v2.user_service.domain.admin.domain.model.AdminPermission;
import com.fream_v2.user_service.domain.admin.domain.model.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 관리자 권한 매핑 엔티티 (Role과 Permission의 관계)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("admin_role_permissions")
public class AdminRolePermissionEntity {
    @Id
    private Long id;
    private String role; // AdminRole enum을 String으로 저장
    private String permission; // AdminPermission enum을 String으로 저장
    private LocalDateTime createdAt;

    /**
     * 권한 매핑 생성
     */
    public static AdminRolePermissionEntity create(AdminRole role, AdminPermission permission) {
        return AdminRolePermissionEntity.builder()
                .role(role.name())
                .permission(permission.name())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
