package com.example.HeekuuTable.repository;

import com.example.HeekuuTable.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreInquiryRepository extends JpaRepository<Store, Long> {
    // 상점 이름순으로 조회
    List<Store> findAllByOrderByNameAsc();

    // 상점 목록을 별점순으로 조회
    List<Store> findAllByOrderByRatingDesc();

    // 상점 목록을 위치 기반으로 조회
    List<Store> findByLocationContaining(String location);
}