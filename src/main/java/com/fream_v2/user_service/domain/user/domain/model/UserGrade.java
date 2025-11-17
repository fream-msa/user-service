package com.fream_v2.user_service.domain.user.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 등급 값 객체
 */
@Getter
@RequiredArgsConstructor
public enum UserGrade {
    VIP("VIP", "1등급", 1000000L), // 100만원 이상 거래
    GRADE_2("GOLD", "2등급", 500000L), // 50만원 이상 거래
    GRADE_3("SILVER", "3등급", 200000L), // 20만원 이상 거래
    GRADE_4("BRONZE", "4등급", 50000L), // 5만원 이상 거래
    GRADE_5("BASIC", "5등급", 0L); // 신규 회원

    private final String code;
    private final String description;
    private final Long requiredAmount; // 승급 필요 거래액

    /**
     * 거래액에 따른 등급 계산
     */
    public static UserGrade calculateGrade(Long totalAmount) {
        if (totalAmount >= VIP.requiredAmount) return VIP;
        if (totalAmount >= GRADE_2.requiredAmount) return GRADE_2;
        if (totalAmount >= GRADE_3.requiredAmount) return GRADE_3;
        if (totalAmount >= GRADE_4.requiredAmount) return GRADE_4;
        return GRADE_5;
    }

    /**
     * 다음 등급 획득까지 필요한 금액
     */
    public Long getAmountToNextGrade() {
        return switch (this) {
            case GRADE_5 -> GRADE_4.requiredAmount;
            case GRADE_4 -> GRADE_3.requiredAmount;
            case GRADE_3 -> GRADE_2.requiredAmount;
            case GRADE_2 -> VIP.requiredAmount;
            case VIP -> 0L; // 최고 등급
        };
    }

    /**
     * 수수료 할인율
     */
    public Double getDiscountRate() {
        return switch (this) {
            case VIP -> 0.5;      // 50% 할인
            case GRADE_2 -> 0.3;  // 30% 할인
            case GRADE_3 -> 0.2;  // 20% 할인
            case GRADE_4 -> 0.1;  // 10% 할인
            case GRADE_5 -> 0.0;  // 할인 없음
        };
    }
}