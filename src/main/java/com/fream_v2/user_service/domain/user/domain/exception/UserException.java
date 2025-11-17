package com.fream_v2.user_service.domain.user.domain.exception;

import com.fream_v2.user_service.global.presentation.exception.ErrorCode;
import com.fream_v2.user_service.global.presentation.exception.GlobalException;

/**
 * 사용자 도메인 예외
 */
public class UserException extends GlobalException {

    public UserException(ErrorCode errorCode) {
        super(errorCode);
    }

    public UserException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public UserException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public UserException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    // ===== 자주 사용되는 예외 생성 정적 팩토리 메서드 =====

    // 조회 관련
    public static UserException notFound() {
        return new UserException(UserErrorCode.USER_NOT_FOUND);
    }

    public static UserException notFound(Long userId) {
        return new UserException(UserErrorCode.USER_ID_NOT_FOUND,
                String.format("사용자를 찾을 수 없습니다. ID: %d", userId));
    }

    public static UserException notFoundByEmail(String email) {
        return new UserException(UserErrorCode.USER_EMAIL_NOT_FOUND,
                String.format("사용자를 찾을 수 없습니다. Email: %s", email));
    }

    // 회원가입 관련
    public static UserException emailAlreadyExists(String email) {
        return new UserException(UserErrorCode.EMAIL_ALREADY_EXISTS,
                String.format("이미 가입된 이메일입니다: %s", email));
    }

    public static UserException usernameAlreadyExists(String username) {
        return new UserException(UserErrorCode.USERNAME_ALREADY_EXISTS,
                String.format("이미 사용 중인 사용자명입니다: %s", username));
    }

    public static UserException invalidEmailFormat() {
        return new UserException(UserErrorCode.INVALID_EMAIL_FORMAT);
    }

    public static UserException invalidPasswordFormat() {
        return new UserException(UserErrorCode.INVALID_PASSWORD_FORMAT);
    }

    // 로그인/인증 관련
    public static UserException invalidCredentials() {
        return new UserException(UserErrorCode.INVALID_CREDENTIALS);
    }

    public static UserException accountSuspended() {
        return new UserException(UserErrorCode.ACCOUNT_SUSPENDED);
    }

    public static UserException accountDeleted() {
        return new UserException(UserErrorCode.ACCOUNT_DELETED);
    }

    public static UserException sessionExpired() {
        return new UserException(UserErrorCode.SESSION_EXPIRED);
    }

    // 권한 관련
    public static UserException insufficientPermission() {
        return new UserException(UserErrorCode.INSUFFICIENT_PERMISSION);
    }

    public static UserException tradeNotAllowed() {
        return new UserException(UserErrorCode.TRADE_NOT_ALLOWED);
    }

    // 등급 관련
    public static UserException invalidGrade(String grade) {
        return new UserException(UserErrorCode.INVALID_GRADE,
                String.format("유효하지 않은 등급입니다: %s", grade));
    }

    public static UserException insufficientTradeAmount(Long currentAmount, Long requiredAmount) {
        return new UserException(UserErrorCode.INSUFFICIENT_TRADE_AMOUNT,
                String.format("등급 승급에 필요한 거래액이 부족합니다. 현재: %d원, 필요: %d원",
                        currentAmount, requiredAmount));
    }

    // 관리자 관련
    public static UserException adminNotFound() {
        return new UserException(UserErrorCode.ADMIN_NOT_FOUND);
    }

    public static UserException adminPermissionDenied() {
        return new UserException(UserErrorCode.ADMIN_PERMISSION_DENIED);
    }

    // 탈퇴 관련
    public static UserException withdrawalNotAllowed(String reason) {
        return new UserException(UserErrorCode.WITHDRAWAL_NOT_ALLOWED,
                String.format("탈퇴할 수 없습니다: %s", reason));
    }
}