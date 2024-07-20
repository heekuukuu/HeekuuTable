package com.example.HeekuuTable.service;

import com.example.HeekuuTable.model.Review;
import com.example.HeekuuTable.model.Store;
import com.example.HeekuuTable.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * 리뷰 남기기 기능
     * @param store 상점 정보
     * @param reviewText 리뷰 내용
     * @return 저장된 리뷰
     */
    public Review leaveReview(Store store, String reviewText) {
        Review review = new Review();
        review.setStore(store);
        review.setReviewText(reviewText);
        return reviewRepository.save(review);
    }

    /**
     * 리뷰 수정 기능
     * @param review 기존 리뷰 정보
     * @param newReviewText 새로운 리뷰 내용
     * @return 수정된 리뷰
     */
    public Review updateReview(Review review, String newReviewText) {
        review.setReviewText(newReviewText);
        return reviewRepository.save(review);
    }
}
