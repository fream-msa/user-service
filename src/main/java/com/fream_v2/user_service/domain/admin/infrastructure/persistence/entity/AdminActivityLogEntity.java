package com.fream_v2.user_service.domain.admin.infrastructure.persistence.entity;

import com.fream_v2.user_service.domain.admin.domain.model.AdminAction;
import com.fream_v2.user_service.domain.admin.domain.model.AdminActivityLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 관리자 활동 로그 엔티티
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("admin_activity_logs")
public class AdminActivityLogEntity {
    @Id
    private Long id;
    private Long adminId;
    private String adminUsername;
    private String action; // AdminAction enum을 String으로 저장
    private String targetType;
    private Long targetId;
    private String description;
    private String ipAddress;
    private String userAgent;
    private LocalDateTime performedAt;

    /**
     * 도메인 모델로 변환
     */
    public AdminActivityLog toDomain() {
        return AdminActivityLog.builder()
                .logId(this.id)
                .adminId(this.adminId)
                .adminUsername(this.adminUsername)
                .action(AdminAction.valueOf(this.action))
                .targetType(this.targetType)
                .targetId(this.targetId)
                .description(this.description)
                .ipAddress(this.ipAddress)
                .userAgent(this.userAgent)
                .performedAt(this.performedAt)
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 생성
     */
    public static AdminActivityLogEntity fromDomain(AdminActivityLog log) {
        return AdminActivityLogEntity.builder()
                .adminId(log.getAdminId())
                .adminUsername(log.getAdminUsername())
                .action(log.getAction().name())
                .targetType(log.getTargetType())
                .targetId(log.getTargetId())
                .description(log.getDescription())
                .ipAddress(log.getIpAddress())
                .userAgent(log.getUserAgent())
                .performedAt(log.getPerformedAt())
                .build();
    }
}
