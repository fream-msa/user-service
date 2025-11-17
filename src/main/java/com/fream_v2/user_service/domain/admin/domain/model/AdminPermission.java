package com.fream_v2.user_service.domain.admin.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 관리자 권한 값 객체
 */
@Getter
@RequiredArgsConstructor
public enum AdminPermission {
    // User 관련
    USER_READ("사용자 조회"),
    USER_UPDATE("사용자 수정"),
    USER_DELETE("사용자 삭제"),
    USER_SUSPEND("사용자 정지"),

    // Product 관련
    PRODUCT_READ("상품 조회"),
    PRODUCT_UPDATE("상품 수정"),
    PRODUCT_DELETE("상품 삭제"),

    // Order 관련
    ORDER_READ("주문 조회"),
    ORDER_UPDATE("주문 수정"),
    ORDER_CANCEL("주문 취소"),

    // Payment 관련
    PAYMENT_READ("결제 조회"),
    PAYMENT_REFUND("환불 처리"),

    // System 관련
    SYSTEM_CONFIG("시스템 설정"),
    ADMIN_MANAGE("관리자 관리"),
    NOTIFICATION_SEND("알림 발송");

    private final String description;
}

