package com.example.hotel.parking;

import lombok.Data;

import java.time.LocalDate;

public record BookParkingRequest(
        Long guestId,
        int parkingSpotId,
        LocalDate checkIn,
        LocalDate checkOut) {
}
