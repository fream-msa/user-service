package com.fream_v2.user_service.domain.user.domain.model;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

/**
 * 사용자 도메인 모델 (순수 도메인)
 */
@Getter
@Builder
public class User {
    private final Long userId;
    private final String username;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final String address;
    private final UserGrade grade;
    private final UserStatus status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    /**
     * 회원가입용 팩토리 메서드
     */
    public static User createUser(String username, String email, String password,
                                  String phoneNumber, String address) {
        return User.builder()
                .username(username)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .address(address)
                .grade(UserGrade.GRADE_5) // 신규 회원은 5등급
                .status(UserStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 프로필 업데이트
     */
    public User updateProfile(String phoneNumber, String address) {
        return User.builder()
                .userId(this.userId)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .phoneNumber(phoneNumber != null ? phoneNumber : this.phoneNumber)
                .address(address != null ? address : this.address)
                .grade(this.grade)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 비밀번호 변경
     */
    public User changePassword(String newPassword) {
        return User.builder()
                .userId(this.userId)
                .username(this.username)
                .email(this.email)
                .password(newPassword)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .grade(this.grade)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 등급 변경
     */
    public User changeGrade(UserGrade newGrade) {
        return User.builder()
                .userId(this.userId)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .grade(newGrade)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 상태 변경
     */
    public User changeStatus(UserStatus newStatus) {
        return User.builder()
                .userId(this.userId)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .grade(this.grade)
                .status(newStatus)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 거래 가능 여부 확인
     */
    public boolean canTrade() {
        return this.status == UserStatus.ACTIVE;
    }

    /**
     * VIP 여부 확인
     */
    public boolean isVip() {
        return this.grade == UserGrade.VIP;
    }
}