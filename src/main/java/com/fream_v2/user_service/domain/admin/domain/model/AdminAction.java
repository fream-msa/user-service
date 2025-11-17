package com.fream_v2.user_service.domain.admin.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 관리자 활동 타입
 */
@Getter
@RequiredArgsConstructor
public enum AdminAction {
    // 사용자 관리
    USER_VIEW("사용자 조회", "READ"),
    USER_UPDATE("사용자 수정", "UPDATE"),
    USER_SUSPEND("사용자 정지", "UPDATE"),
    USER_ACTIVATE("사용자 활성화", "UPDATE"),
    USER_DELETE("사용자 삭제", "DELETE"),
    USER_GRADE_CHANGE("사용자 등급 변경", "UPDATE"),

    // 상품 관리
    PRODUCT_VIEW("상품 조회", "READ"),
    PRODUCT_UPDATE("상품 수정", "UPDATE"),
    PRODUCT_SUSPEND("상품 중지", "UPDATE"),
    PRODUCT_ACTIVATE("상품 활성화", "UPDATE"),
    PRODUCT_DELETE("상품 삭제", "DELETE"),

    // 거래 관리
    TRADE_VIEW("거래 조회", "READ"),
    TRADE_CANCEL("거래 취소", "UPDATE"),
    PAYMENT_VIEW("결제 조회", "READ"),
    PAYMENT_CANCEL("결제 취소", "UPDATE"),
    PAYMENT_REFUND("환불 처리", "UPDATE"),

    // 관리자 관리
    ADMIN_CREATE("관리자 생성", "CREATE"),
    ADMIN_UPDATE("관리자 수정", "UPDATE"),
    ADMIN_DELETE("관리자 삭제", "DELETE"),
    ADMIN_ROLE_CHANGE("관리자 역할 변경", "UPDATE"),

    // 시스템 관리
    SYSTEM_CONFIG_UPDATE("시스템 설정 변경", "UPDATE"),
    NOTIFICATION_SEND("알림 발송", "CREATE"),
    BACKUP_CREATE("백업 생성", "CREATE"),
    LOG_EXPORT("로그 내보내기", "READ"),

    // 인증 관련
    LOGIN("로그인", "AUTH"),
    LOGOUT("로그아웃", "AUTH"),
    PASSWORD_CHANGE("비밀번호 변경", "UPDATE"),
    TWO_FACTOR_ENABLE("2차 인증 활성화", "UPDATE"),
    TWO_FACTOR_DISABLE("2차 인증 비활성화", "UPDATE");

    private final String description;
    private final String type;

    /**
     * 중요도 판단
     */
    public boolean isCritical() {
        return type.equals("DELETE") ||
                this == PAYMENT_REFUND ||
                this == SYSTEM_CONFIG_UPDATE ||
                this == ADMIN_ROLE_CHANGE;
    }

    /**
     * 감사 필요 여부
     */
    public boolean requiresAudit() {
        return isCritical() || type.equals("UPDATE");
    }
}
