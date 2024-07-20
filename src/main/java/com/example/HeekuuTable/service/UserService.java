package com.example.HeekuuTable.service;

import com.example.HeekuuTable.model.Store;
import com.example.HeekuuTable.model.Customer;
import com.example.HeekuuTable.repository.StoreInquiryRepository;
import com.example.HeekuuTable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private static StoreInquiryRepository storeInquiryRepository;

    @Autowired
    private UserRepository userRepository; // UserRepository 주입

    /**
     * 상점 목록을 가나다순으로 조회
     * @return 가나다순으로 정렬된 상점 목록
     */
    public static List<Store> getStoresAlphabetically() {
        return storeInquiryRepository.findAllByOrderByNameAsc();
    }

    /**
     * 상점 목록을 별점순으로 조회
     * @return 별점순으로 정렬된 상점 목록
     */
    public  List<Store> getStoresByRating() {
        return storeInquiryRepository.findAllByOrderByRatingDesc();
    }

    /**
     * 상점 목록을 위치 기반으로 조회
     * @param location 검색할 위치
     * @return 해당 위치에 있는 상점 목록
     */
    public List<Store> getStoresByLocation(String location) {
        return storeInquiryRepository.findByLocationContaining(location);
    }

    /**
     * 상점 ID로 상점 조회
     * @param storeId 상점 ID
     * @return 상점 정보
     */
    public Store getStoreById(Long storeId) {
        return storeInquiryRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found with id " + storeId));
    }

    /**
     * 사용자 정보 저장
     * @param customer 사용자 정보
     */
    public void saveUser(Customer customer) {
        userRepository.save(customer); // 인스턴스 메서드 호출
    }

    /**
     *  전화번호로 사용자 조회
     * @param phoneNumber 전화번호
     * @return 사용자 정보
     */
  public Customer findByPhoneNumber(String phoneNumber) {
    return userRepository.findByPhoneNumber(phoneNumber);
}


}