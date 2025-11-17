package com.fream_v2.user_service.domain.admin.domain.exception;

import com.fream_v2.user_service.global.presentation.exception.ErrorCode;
import com.fream_v2.user_service.global.presentation.exception.GlobalException;
import com.fream_v2.user_service.domain.admin.domain.model.AdminPermission;

/**
 * 관리자 도메인 예외
 */
public class AdminException extends GlobalException {

    public AdminException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AdminException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public AdminException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public AdminException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    // ===== 자주 사용되는 예외 생성 정적 팩토리 메서드 =====

    // 조회 관련
    public static AdminException notFound() {
        return new AdminException(AdminErrorCode.ADMIN_NOT_FOUND);
    }

    public static AdminException notFound(Long adminId) {
        return new AdminException(AdminErrorCode.ADMIN_ID_NOT_FOUND,
                String.format("관리자를 찾을 수 없습니다. ID: %d", adminId));
    }

    public static AdminException notFoundByEmail(String email) {
        return new AdminException(AdminErrorCode.ADMIN_EMAIL_NOT_FOUND,
                String.format("관리자를 찾을 수 없습니다. Email: %s", email));
    }

    // 등록 관련
    public static AdminException emailAlreadyExists(String email) {
        return new AdminException(AdminErrorCode.ADMIN_EMAIL_ALREADY_EXISTS,
                String.format("이미 등록된 관리자 이메일입니다: %s", email));
    }

    public static AdminException usernameAlreadyExists(String username) {
        return new AdminException(AdminErrorCode.ADMIN_USERNAME_ALREADY_EXISTS,
                String.format("이미 존재하는 관리자명입니다: %s", username));
    }

    public static AdminException masterAlreadyExists() {
        return new AdminException(AdminErrorCode.MASTER_ALREADY_EXISTS);
    }

    public static AdminException invalidRole(String role) {
        return new AdminException(AdminErrorCode.INVALID_ADMIN_ROLE,
                String.format("유효하지 않은 관리자 역할입니다: %s", role));
    }

    // 인증/권한 관련
    public static AdminException invalidCredentials() {
        return new AdminException(AdminErrorCode.ADMIN_INVALID_CREDENTIALS);
    }

    public static AdminException accountSuspended() {
        return new AdminException(AdminErrorCode.ADMIN_ACCOUNT_SUSPENDED);
    }

    public static AdminException sessionExpired() {
        return new AdminException(AdminErrorCode.ADMIN_SESSION_EXPIRED);
    }

    public static AdminException twoFactorRequired() {
        return new AdminException(AdminErrorCode.ADMIN_2FA_REQUIRED);
    }

    public static AdminException ipNotAllowed(String ipAddress) {
        return new AdminException(AdminErrorCode.ADMIN_IP_NOT_ALLOWED,
                String.format("허용되지 않은 IP 주소입니다: %s", ipAddress));
    }

    // 권한 관련
    public static AdminException permissionDenied() {
        return new AdminException(AdminErrorCode.ADMIN_PERMISSION_DENIED);
    }

    public static AdminException permissionDenied(AdminPermission permission) {
        return new AdminException(AdminErrorCode.ADMIN_PERMISSION_DENIED,
                String.format("권한이 없습니다: %s", permission.getDescription()));
    }

    public static AdminException cannotModifyMaster() {
        return new AdminException(AdminErrorCode.CANNOT_MODIFY_MASTER);
    }

    public static AdminException cannotDeleteMaster() {
        return new AdminException(AdminErrorCode.CANNOT_DELETE_MASTER);
    }

    public static AdminException onlyMasterAllowed() {
        return new AdminException(AdminErrorCode.ONLY_MASTER_ALLOWED);
    }

    public static AdminException cannotChangeOwnRole() {
        return new AdminException(AdminErrorCode.CANNOT_CHANGE_OWN_ROLE);
    }

    public static AdminException cannotDeleteSelf() {
        return new AdminException(AdminErrorCode.CANNOT_DELETE_SELF);
    }

    // 사용자 관리 관련
    public static AdminException userManagementDenied() {
        return new AdminException(AdminErrorCode.USER_MANAGEMENT_DENIED);
    }

    public static AdminException userSuspensionDenied() {
        return new AdminException(AdminErrorCode.USER_SUSPENSION_DENIED);
    }

    public static AdminException userDeletionDenied() {
        return new AdminException(AdminErrorCode.USER_DELETION_DENIED);
    }

    // 상품 관리 관련
    public static AdminException productManagementDenied() {
        return new AdminException(AdminErrorCode.PRODUCT_MANAGEMENT_DENIED);
    }

    public static AdminException productSuspensionDenied() {
        return new AdminException(AdminErrorCode.PRODUCT_SUSPENSION_DENIED);
    }

    // 거래 관리 관련
    public static AdminException tradeManagementDenied() {
        return new AdminException(AdminErrorCode.TRADE_MANAGEMENT_DENIED);
    }

    public static AdminException paymentManagementDenied() {
        return new AdminException(AdminErrorCode.PAYMENT_MANAGEMENT_DENIED);
    }

    public static AdminException refundProcessingDenied() {
        return new AdminException(AdminErrorCode.REFUND_PROCESSING_DENIED);
    }

    // 시스템 관리 관련
    public static AdminException systemConfigDenied() {
        return new AdminException(AdminErrorCode.SYSTEM_CONFIG_DENIED);
    }

    public static AdminException adminManagementDenied() {
        return new AdminException(AdminErrorCode.ADMIN_MANAGEMENT_DENIED);
    }

    public static AdminException notificationSendDenied() {
        return new AdminException(AdminErrorCode.NOTIFICATION_SEND_DENIED);
    }
}