package com.example.HeekuuTable.controller;

import com.example.HeekuuTable.dto.StoreRequestDto; // StoreRequestDto 임포트
import com.example.HeekuuTable.model.Store;
import com.example.HeekuuTable.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 매장 생성 엔드포인트 (매니저 권한 필요)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping("/create")
    public Store createStore(@RequestBody StoreRequestDto storeRequestDto) {
        return storeService.createStore(storeRequestDto);
    }

    // 매장 수정 엔드포인트 (매니저 권한 필요)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PutMapping("/update/{id}")
    public Store updateStore(@PathVariable Long id, @RequestBody StoreRequestDto storeRequestDto) {
        return storeService.updateStore(id, storeRequestDto);
    }

    // 매장 삭제 엔드포인트 (매니저 권한 필요)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @DeleteMapping("/delete/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }

    // 모든 매장 조회 엔드포인트
    @GetMapping("/all")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }
}