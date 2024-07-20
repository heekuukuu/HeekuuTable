package com.example.HeekuuTable.dto;

import com.example.HeekuuTable.grade.RoleName;

/**
 * 회원가입 요청을 처리하는 DTO(Data Transfer Object) 클래스입니다.
 * 회원가입에 필요한 필드를 포함합니다.
 */
public class SignupRequestDto {
    private String phoneNumber; // 사용자의 전화번호
    private String name;        // 사용자의 이름
    private String password;    // 사용자의 비밀번호
    private RoleName role;      // 사용자의 역할 (ROLE_CUSTOMER 또는 ROLE_MANAGER)

    // 전화번호 Getter 및 Setter
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // 이름 Getter 및 Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 비밀번호 Getter 및 Setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 역할 Getter 및 Setter
    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}