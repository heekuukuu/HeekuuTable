package com.example.HeekuuTable.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;
import org.hibernate.envers.AuditOverride;
import org.springframework.cglib.core.Local;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 시스템에서 사용자 정보를 나타내는 엔티티 클래스입니다.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AuditOverride(forClass = BaseEntity.class)

public class Customer extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자의 이메일
    @Column(unique = true)
    private String email;
    // 사용자의 이름
    private String name;
    // 사용자의 비밀번호
    private String password;
    // 사용자의 전화번호
    private String phone;
    // 사용자의 생일
    private LocalDate birth;

    private LocalDateTime verifyExpiredAt;
    private String verificationCode;
    private boolean verify;

    public static Customer from(SignUpForm form){
        return Customer.builder()
                .email(form.getEmail().toLowerCase(Local.ROOT))
                .password(form.getPassword())
                .name(form.getName())
                .birth(form.getBirth())
                .phone(form.getPhone())
                .verify(false)
                .build();



    }

}