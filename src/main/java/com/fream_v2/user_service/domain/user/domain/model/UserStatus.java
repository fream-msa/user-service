package com.fream_v2.user_service.domain.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 상태 값 객체
 */
@Getter
@RequiredArgsConstructor
public enum UserStatus {
    ACTIVE("활성", "정상적으로 서비스를 이용할 수 있는 상태"),
    SUSPENDED("정지", "일시적으로 서비스 이용이 제한된 상태"),
    DELETED("삭제", "탈퇴한 상태"),
    PENDING("대기", "이메일 인증 대기 중인 상태");

    private final String description;
    private final String detail;

    /**
     * 거래 가능 상태 확인
     */
    public boolean canTrade() {
        return this == ACTIVE;
    }

    /**
     * 로그인 가능 상태 확인
     */
    public boolean canLogin() {
        return this == ACTIVE || this == PENDING;
    }
}