package com.example.HeekuuTable.repository;

import com.example.HeekuuTable.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User 엔티티를 위한 레포지토리 인터페이스입니다.
 * CRUD 작업을 제공하기 위해 JpaRepository를 확장합니다.
 */
@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {
    // 전화번호로 사용자를 찾는 메소드
    Customer findByPhoneNumber(String phoneNumber);


}