package com.fream_v2.user_service.domain.user.domain.exception;

import com.fream_v2.user_service.global.presentation.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 도메인 에러 코드
 */
@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    // ===== 사용자 조회 관련 (USER_001 ~ USER_099) =====
    USER_NOT_FOUND("USER_001", "사용자를 찾을 수 없습니다.", 404),
    USER_ID_NOT_FOUND("USER_002", "해당 ID의 사용자를 찾을 수 없습니다.", 404),
    USER_EMAIL_NOT_FOUND("USER_003", "해당 이메일의 사용자를 찾을 수 없습니다.", 404),
    USER_DATA_CORRUPTED("USER_004", "사용자 데이터가 손상되었습니다.", 500),

    // ===== 회원가입 관련 (USER_100 ~ USER_199) =====
    USERNAME_ALREADY_EXISTS("USER_100", "이미 존재하는 사용자명입니다.", 409),
    EMAIL_ALREADY_EXISTS("USER_101", "이미 가입된 이메일입니다.", 409),
    INVALID_EMAIL_FORMAT("USER_102", "올바른 이메일 형식이 아닙니다.", 400),
    INVALID_PASSWORD_FORMAT("USER_103", "비밀번호는 8자 이상, 영문, 숫자, 특수문자를 포함해야 합니다.", 400),
    INVALID_PHONE_FORMAT("USER_104", "올바른 전화번호 형식이 아닙니다.", 400),
    INVALID_USERNAME_FORMAT("USER_105", "사용자명은 2-20자의 영문, 숫자, 한글만 가능합니다.", 400),
    REGISTRATION_FAILED("USER_106", "회원가입 처리 중 오류가 발생했습니다.", 500),
    TERMS_NOT_AGREED("USER_107", "필수 약관에 동의하지 않았습니다.", 400),
    AGE_RESTRICTION("USER_108", "만 14세 이상만 가입 가능합니다.", 400),

    // ===== 로그인/인증 관련 (USER_200 ~ USER_299) =====
    INVALID_CREDENTIALS("USER_200", "이메일 또는 비밀번호가 일치하지 않습니다.", 401),
    ACCOUNT_SUSPENDED("USER_201", "정지된 계정입니다.", 403),
    ACCOUNT_DELETED("USER_202", "삭제된 계정입니다.", 403),
    ACCOUNT_NOT_VERIFIED("USER_203", "이메일 인증이 필요합니다.", 403),
    PASSWORD_MISMATCH("USER_204", "현재 비밀번호가 일치하지 않습니다.", 400),
    PASSWORD_RECENTLY_USED("USER_205", "최근에 사용한 비밀번호는 재사용할 수 없습니다.", 400),
    LOGIN_ATTEMPT_EXCEEDED("USER_206", "로그인 시도 횟수를 초과했습니다. 잠시 후 다시 시도해주세요.", 429),
    SESSION_EXPIRED("USER_207", "세션이 만료되었습니다.", 401),
    INVALID_TOKEN("USER_208", "유효하지 않은 토큰입니다.", 401),

    // ===== 프로필/정보 수정 관련 (USER_300 ~ USER_399) =====
    CANNOT_UPDATE_EMAIL("USER_300", "이메일은 변경할 수 없습니다.", 400),
    CANNOT_UPDATE_USERNAME("USER_301", "사용자명은 변경할 수 없습니다.", 400),
    PROFILE_UPDATE_FAILED("USER_302", "프로필 업데이트에 실패했습니다.", 500),
    INVALID_ADDRESS_FORMAT("USER_303", "올바른 주소 형식이 아닙니다.", 400),
    PROFILE_IMAGE_TOO_LARGE("USER_304", "프로필 이미지 크기는 5MB 이하여야 합니다.", 400),
    INVALID_PROFILE_IMAGE_FORMAT("USER_305", "지원하지 않는 이미지 형식입니다.", 400),

    // ===== 등급 관련 (USER_400 ~ USER_499) =====
    GRADE_UPDATE_FAILED("USER_400", "등급 업데이트에 실패했습니다.", 500),
    INVALID_GRADE("USER_401", "유효하지 않은 등급입니다.", 400),
    GRADE_DOWNGRADE_NOT_ALLOWED("USER_402", "등급 강등은 관리자만 가능합니다.", 403),
    INSUFFICIENT_TRADE_AMOUNT("USER_403", "등급 승급에 필요한 거래액이 부족합니다.", 400),

    // ===== 권한 관련 (USER_500 ~ USER_599) =====
    INSUFFICIENT_PERMISSION("USER_500", "해당 작업을 수행할 권한이 없습니다.", 403),
    TRADE_NOT_ALLOWED("USER_501", "거래가 제한된 사용자입니다.", 403),
    REVIEW_NOT_ALLOWED("USER_502", "리뷰 작성 권한이 없습니다.", 403),

    // ===== 탈퇴 관련 (USER_600 ~ USER_699) =====
    WITHDRAWAL_NOT_ALLOWED("USER_600", "진행 중인 거래가 있어 탈퇴할 수 없습니다.", 400),
    WITHDRAWAL_PERIOD_RESTRICTION("USER_601", "가입 후 7일 이내에는 탈퇴할 수 없습니다.", 400),
    ALREADY_WITHDRAWN("USER_602", "이미 탈퇴한 계정입니다.", 400),

    // ===== 관리자 관련 (USER_700 ~ USER_799) =====
    ADMIN_NOT_FOUND("USER_700", "관리자를 찾을 수 없습니다.", 404),
    ADMIN_PERMISSION_DENIED("USER_701", "관리자 권한이 없습니다.", 403),
    CANNOT_MODIFY_MASTER("USER_702", "마스터 관리자는 수정할 수 없습니다.", 403),
    INVALID_ADMIN_ROLE("USER_703", "유효하지 않은 관리자 역할입니다.", 400),

    // ===== 검증 관련 (USER_800 ~ USER_899) =====
    USER_DATA_INVALID("USER_800", "사용자 데이터가 유효하지 않습니다.", 400),
    REQUIRED_FIELD_MISSING("USER_801", "필수 입력 항목이 누락되었습니다.", 400),
    DUPLICATE_REQUEST("USER_802", "중복된 요청입니다.", 409),
    VERIFICATION_CODE_INVALID("USER_803", "인증 코드가 유효하지 않습니다.", 400),
    VERIFICATION_CODE_EXPIRED("USER_804", "인증 코드가 만료되었습니다.", 400);

    private final String code;
    private final String message;
    private final int status;
}