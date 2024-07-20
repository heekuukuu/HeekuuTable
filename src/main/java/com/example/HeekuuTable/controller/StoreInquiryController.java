package com.example.HeekuuTable.controller;


import com.example.HeekuuTable.model.Store;
import com.example.HeekuuTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 상점조회장치
@RestController
public class StoreInquiryController {

    @Autowired
    private UserService userService;

    // 상점 목록을 가나다순으로 조회
    @GetMapping("/stores/alphabetical")
    private ResponseEntity<List<Store>> getStoresAlphabetically(){
        return ResponseEntity.ok(UserService.getStoresAlphabetically());
    }

    // 상점 목록을 별점순으로 조회
    @GetMapping("/stores/rating")
    public ResponseEntity<List<Store>> getStoresByRating() {
        return ResponseEntity.ok(userService.getStoresByRating());
    }
    // 상점목록을 위치 기반으로 조회
    @GetMapping("/stores/location")
    public ResponseEntity<List<Store>> getStoresByLocation(@RequestParam String location) {
        return ResponseEntity.ok(userService.getStoresByLocation(location));
    }
    }

