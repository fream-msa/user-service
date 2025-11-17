package com.fream_v2.user_service.domain.admin.domain.exception;

import com.fream_v2.user_service.global.presentation.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 관리자 도메인 에러 코드
 */
@Getter
@RequiredArgsConstructor
public enum AdminErrorCode implements ErrorCode {

    // ===== 관리자 조회 관련 (ADMIN_001 ~ ADMIN_099) =====
    ADMIN_NOT_FOUND("ADMIN_001", "관리자를 찾을 수 없습니다.", 404),
    ADMIN_ID_NOT_FOUND("ADMIN_002", "해당 ID의 관리자를 찾을 수 없습니다.", 404),
    ADMIN_EMAIL_NOT_FOUND("ADMIN_003", "해당 이메일의 관리자를 찾을 수 없습니다.", 404),
    ADMIN_DATA_CORRUPTED("ADMIN_004", "관리자 데이터가 손상되었습니다.", 500),

    // ===== 관리자 등록 관련 (ADMIN_100 ~ ADMIN_199) =====
    ADMIN_USERNAME_ALREADY_EXISTS("ADMIN_100", "이미 존재하는 관리자명입니다.", 409),
    ADMIN_EMAIL_ALREADY_EXISTS("ADMIN_101", "이미 등록된 관리자 이메일입니다.", 409),
    INVALID_ADMIN_EMAIL_FORMAT("ADMIN_102", "올바른 이메일 형식이 아닙니다.", 400),
    INVALID_ADMIN_PASSWORD_FORMAT("ADMIN_103", "관리자 비밀번호는 10자 이상, 대소문자, 숫자, 특수문자를 포함해야 합니다.", 400),
    ADMIN_REGISTRATION_FAILED("ADMIN_104", "관리자 등록에 실패했습니다.", 500),
    MASTER_ALREADY_EXISTS("ADMIN_105", "마스터 관리자는 이미 존재합니다.", 409),
    ADMIN_LIMIT_EXCEEDED("ADMIN_106", "관리자 수 제한을 초과했습니다.", 400),
    INVALID_ADMIN_ROLE("ADMIN_107", "유효하지 않은 관리자 역할입니다.", 400),

    // ===== 관리자 인증/권한 관련 (ADMIN_200 ~ ADMIN_299) =====
    ADMIN_INVALID_CREDENTIALS("ADMIN_200", "관리자 인증 정보가 일치하지 않습니다.", 401),
    ADMIN_ACCOUNT_SUSPENDED("ADMIN_201", "정지된 관리자 계정입니다.", 403),
    ADMIN_ACCOUNT_DELETED("ADMIN_202", "삭제된 관리자 계정입니다.", 403),
    ADMIN_SESSION_EXPIRED("ADMIN_203", "관리자 세션이 만료되었습니다.", 401),
    ADMIN_2FA_REQUIRED("ADMIN_204", "2차 인증이 필요합니다.", 401),
    ADMIN_2FA_FAILED("ADMIN_205", "2차 인증에 실패했습니다.", 401),
    ADMIN_IP_NOT_ALLOWED("ADMIN_206", "허용되지 않은 IP 주소입니다.", 403),
    ADMIN_LOGIN_ATTEMPT_EXCEEDED("ADMIN_207", "로그인 시도 횟수를 초과했습니다.", 429),

    // ===== 관리자 권한 관련 (ADMIN_300 ~ ADMIN_399) =====
    ADMIN_PERMISSION_DENIED("ADMIN_300", "해당 작업에 대한 권한이 없습니다.", 403),
    CANNOT_MODIFY_MASTER("ADMIN_301", "마스터 관리자는 수정할 수 없습니다.", 403),
    CANNOT_DELETE_MASTER("ADMIN_302", "마스터 관리자는 삭제할 수 없습니다.", 403),
    CANNOT_SUSPEND_MASTER("ADMIN_303", "마스터 관리자는 정지할 수 없습니다.", 403),
    ONLY_MASTER_ALLOWED("ADMIN_304", "마스터 관리자만 수행할 수 있는 작업입니다.", 403),
    MANAGER_PERMISSION_INSUFFICIENT("ADMIN_305", "매니저 권한으로는 수행할 수 없습니다.", 403),
    CANNOT_CHANGE_OWN_ROLE("ADMIN_306", "자신의 역할은 변경할 수 없습니다.", 403),
    CANNOT_DELETE_SELF("ADMIN_307", "자기 자신은 삭제할 수 없습니다.", 403),

    // ===== 사용자 관리 권한 관련 (ADMIN_400 ~ ADMIN_499) =====
    USER_MANAGEMENT_DENIED("ADMIN_400", "사용자 관리 권한이 없습니다.", 403),
    USER_SUSPENSION_DENIED("ADMIN_401", "사용자 정지 권한이 없습니다.", 403),
    USER_DELETION_DENIED("ADMIN_402", "사용자 삭제 권한이 없습니다.", 403),
    USER_GRADE_CHANGE_DENIED("ADMIN_403", "사용자 등급 변경 권한이 없습니다.", 403),

    // ===== 상품 관리 권한 관련 (ADMIN_500 ~ ADMIN_599) =====
    PRODUCT_MANAGEMENT_DENIED("ADMIN_500", "상품 관리 권한이 없습니다.", 403),
    PRODUCT_SUSPENSION_DENIED("ADMIN_501", "상품 중지 권한이 없습니다.", 403),
    PRODUCT_DELETION_DENIED("ADMIN_502", "상품 삭제 권한이 없습니다.", 403),

    // ===== 거래 관리 권한 관련 (ADMIN_600 ~ ADMIN_699) =====
    TRADE_MANAGEMENT_DENIED("ADMIN_600", "거래 관리 권한이 없습니다.", 403),
    TRADE_CANCELLATION_DENIED("ADMIN_601", "거래 취소 권한이 없습니다.", 403),
    PAYMENT_MANAGEMENT_DENIED("ADMIN_602", "결제 관리 권한이 없습니다.", 403),
    REFUND_PROCESSING_DENIED("ADMIN_603", "환불 처리 권한이 없습니다.", 403),

    // ===== 시스템 관리 관련 (ADMIN_700 ~ ADMIN_799) =====
    SYSTEM_CONFIG_DENIED("ADMIN_700", "시스템 설정 권한이 없습니다.", 403),
    ADMIN_MANAGEMENT_DENIED("ADMIN_701", "관리자 관리 권한이 없습니다.", 403),
    NOTIFICATION_SEND_DENIED("ADMIN_702", "알림 발송 권한이 없습니다.", 403),
    LOG_ACCESS_DENIED("ADMIN_703", "로그 접근 권한이 없습니다.", 403),
    BACKUP_ACCESS_DENIED("ADMIN_704", "백업 접근 권한이 없습니다.", 403),

    // ===== 감사(Audit) 관련 (ADMIN_800 ~ ADMIN_899) =====
    AUDIT_LOG_CREATE_FAILED("ADMIN_800", "감사 로그 생성에 실패했습니다.", 500),
    AUDIT_LOG_NOT_FOUND("ADMIN_801", "감사 로그를 찾을 수 없습니다.", 404),
    AUDIT_TRAIL_CORRUPTED("ADMIN_802", "감사 추적 정보가 손상되었습니다.", 500),

    // ===== 검증 관련 (ADMIN_900 ~ ADMIN_999) =====
    ADMIN_DATA_INVALID("ADMIN_900", "관리자 데이터가 유효하지 않습니다.", 400),
    REQUIRED_FIELD_MISSING("ADMIN_901", "필수 입력 항목이 누락되었습니다.", 400),
    INVALID_ADMIN_STATUS("ADMIN_902", "유효하지 않은 관리자 상태입니다.", 400),
    ADMIN_SESSION_INVALID("ADMIN_903", "유효하지 않은 관리자 세션입니다.", 401);

    private final String code;
    private final String message;
    private final int status;
}