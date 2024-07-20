package com.example.HeekuuTable.controller;

import com.example.HeekuuTable.model.Reservation;
import com.example.HeekuuTable.model.Store;
import com.example.HeekuuTable.service.ReservationService;
import com.example.HeekuuTable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    // 예약 요청
    @PostMapping
    public ResponseEntity<Reservation> makeReservation(@RequestParam Long storeId,
                                                       @RequestParam String reservationTime,
                                                       @RequestParam String phoneNumber) {
        Store store = userService.getStoreById(storeId);
        LocalDateTime dateTime = LocalDateTime.parse(reservationTime);
        Reservation reservation = reservationService.makeReservation(store, dateTime, phoneNumber);
        return ResponseEntity.ok(reservation);
    }

    // 예약 도착 확인
    @PostMapping("/checkin")
    public ResponseEntity<Boolean> checkIn(@RequestParam Long reservationId) {
        Optional<Reservation> reservationOpt = reservationService.getReservationById(reservationId);
        if (reservationOpt.isPresent()) {
            Reservation reservation = reservationOpt.get();
            boolean canCheckIn = reservationService.checkIn(reservation);
            return ResponseEntity.ok(canCheckIn);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}