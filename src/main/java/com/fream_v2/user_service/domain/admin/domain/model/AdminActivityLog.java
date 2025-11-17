package com.fream_v2.user_service.domain.admin.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 관리자 활동 로그 도메인 모델
 */
@Getter
@Builder
public class AdminActivityLog {
    private final Long logId;
    private final Long adminId;
    private final String adminUsername;
    private final AdminAction action;
    private final String targetType;
    private final Long targetId;
    private final String description;
    private final String ipAddress;
    private final String userAgent;
    private final LocalDateTime performedAt;

    /**
     * 활동 로그 생성
     */
    public static AdminActivityLog createLog(Long adminId, String adminUsername,
                                             AdminAction action, String targetType,
                                             Long targetId, String description,
                                             String ipAddress, String userAgent) {
        return AdminActivityLog.builder()
                .adminId(adminId)
                .adminUsername(adminUsername)
                .action(action)
                .targetType(targetType)
                .targetId(targetId)
                .description(description)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .performedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 로그 메시지 생성
     */
    public String getLogMessage() {
        return String.format("[%s] Admin: %s, Action: %s, Target: %s(%d), IP: %s",
                performedAt, adminUsername, action.getDescription(),
                targetType, targetId, ipAddress);
    }
}
