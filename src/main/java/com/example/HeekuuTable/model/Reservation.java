package com.example.HeekuuTable.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;   // 상점

    @Column(nullable = false)
    private LocalDateTime reservationTime;  // 도착시간

    @Column(nullable = false)
    private String phoneNumber;  // 폰번호
    @Column(nullable = false)
    private boolean checkedIn; // 체크인
    // 예약 기능: 상점, 날짜, 시간, 핸드폰 번호를 통해 예약합니다.
}