package com.fream_v2.user_service.domain.user.infrastructure.persistence.entity;

import com.fream_v2.user_service.domain.user.domain.model.User;
import com.fream_v2.user_service.domain.user.domain.model.UserGrade;
import com.fream_v2.user_service.domain.user.domain.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 사용자 엔티티 (Infrastructure Layer)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("users")
public class UserEntity {
    @Id
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String grade; // UserGrade enum을 String으로 저장
    private String status; // UserStatus enum을 String으로 저장
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * 도메인 모델로 변환
     */
    public User toDomain() {
        return User.builder()
                .userId(this.id)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .grade(UserGrade.valueOf(this.grade))
                .status(UserStatus.valueOf(this.status))
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 생성 (신규)
     */
    public static UserEntity fromDomain(User user) {
        return UserEntity.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .grade(user.getGrade().name())
                .status(user.getStatus().name())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 업데이트 (기존 ID 포함)
     */
    public static UserEntity updateFromDomain(User user) {
        return UserEntity.builder()
                .id(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .grade(user.getGrade().name())
                .status(user.getStatus().name())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}

