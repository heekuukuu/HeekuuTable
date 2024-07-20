package com.example.HeekuuTable.service;

import com.example.HeekuuTable.dto.StoreRequestDto;
import com.example.HeekuuTable.model.Store;
import com.example.HeekuuTable.repository.StoreInquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreInquiryRepository storeInquiryRepository;

    // 매장 생성 메서드
    public Store createStore(StoreRequestDto storeRequestDto) {
        Store store = new Store();
        store.setName(storeRequestDto.getName());
        store.setAddress(storeRequestDto.getAddress());
        store.setPhoneNumber(storeRequestDto.getPhoneNumber());
        store.setRating(storeRequestDto.getRating());
        store.setLocation(storeRequestDto.getLocation());
        return storeInquiryRepository.save(store);
    }

    // 매장 수정 메서드
    public Store updateStore(Long id, StoreRequestDto storeRequestDto) {
        Optional<Store> optionalStore = storeInquiryRepository.findById(id);
        if (optionalStore.isPresent()) {
            Store store = optionalStore.get();
            store.setName(storeRequestDto.getName());
            store.setAddress(storeRequestDto.getAddress());
            store.setPhoneNumber(storeRequestDto.getPhoneNumber());
            store.setRating(storeRequestDto.getRating());
            store.setLocation(storeRequestDto.getLocation());
            return storeInquiryRepository.save(store);
        } else {
            throw new RuntimeException("Store not found with id " + id);
        }
    }

    // 매장 삭제 메서드
    public void deleteStore(Long id) {
        storeInquiryRepository.deleteById(id);
    }

    // 모든 매장 조회 메서드
    public List<Store> getAllStores() {
        return storeInquiryRepository.findAll();
    }

    // 상점 이름순으로 조회
    public List<Store> getStoresOrderedByName() {
        return storeInquiryRepository.findAllByOrderByNameAsc();
    }

    // 상점 목록을 별점순으로 조회
    public List<Store> getStoresOrderedByRating() {
        return storeInquiryRepository.findAllByOrderByRatingDesc();
    }

    // 상점 목록을 위치 기반으로 조회
    public List<Store> getStoresByLocation(String location) {
        return storeInquiryRepository.findByLocationContaining(location);
    }
}