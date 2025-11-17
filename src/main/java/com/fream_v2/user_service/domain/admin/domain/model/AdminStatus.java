package com.fream_v2.user_service.domain.admin.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 관리자 상태 값 객체
 */
@Getter
@RequiredArgsConstructor
public enum AdminStatus {
    ACTIVE("활성", "정상 활동 중"),
    INACTIVE("비활성", "일시 중지"),
    DELETED("삭제", "권한 회수");

    private final String name;
    private final String description;
}
