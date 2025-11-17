package com.fream_v2.user_service.domain.admin.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * 관리자 역할 값 객체
 */
@Getter
@RequiredArgsConstructor
public enum AdminRole {
    MASTER("마스터", "모든 권한", Set.of(AdminPermission.values())),
    MANAGER("매니저", "일반 관리 권한", Set.of(
            AdminPermission.USER_READ,
            AdminPermission.USER_UPDATE,
            AdminPermission.PRODUCT_READ,
            AdminPermission.PRODUCT_UPDATE,
            AdminPermission.ORDER_READ,
            AdminPermission.ORDER_UPDATE,
            AdminPermission.NOTIFICATION_SEND
    ));

    private final String name;
    private final String description;
    private final Set<AdminPermission> permissions;

    public boolean hasPermission(AdminPermission permission) {
        return permissions.contains(permission);
    }
}
