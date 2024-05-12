package com.example.hotel.parking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
public class BookParkingResponse {
    private UUID bookingId;
    private int parkingSpotNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double price;


    void generateBookingId() {
        this.bookingId = UUID.randomUUID();
    }
}
