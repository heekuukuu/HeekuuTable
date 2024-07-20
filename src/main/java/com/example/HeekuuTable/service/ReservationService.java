package com.example.HeekuuTable.service;

import com.example.HeekuuTable.model.Reservation;
import com.example.HeekuuTable.model.Store;
import com.example.HeekuuTable.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * 상점 예약 요청 기능
     * @param store 상점 정보
     * @param reservationTime 예약 시간
     * @param phoneNumber 핸드폰 번호
     * @return 예약 정보
     */
    public Reservation makeReservation(Store store, LocalDateTime reservationTime, String phoneNumber) {
        Reservation reservation = new Reservation();
        reservation.setStore(store);
        reservation.setReservationTime(reservationTime);
        reservation.setPhoneNumber(phoneNumber);
        return reservationRepository.save(reservation);
    }

    /**
     * 예약 도착 기능
     * @param reservation 예약 정보
     * @return 도착 가능 여부
     */
    public boolean checkIn(Reservation reservation) {
        if (reservation.getReservationTime().isAfter(LocalDateTime.now().minusMinutes(10))) {
            reservation.setCheckedIn(true);
            reservationRepository.save(reservation);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 예약 ID로 예약 조회 기능
     * @param id 예약 ID
     * @return 예약 정보
     */
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }
}