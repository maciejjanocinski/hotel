package com.example.hotel.rooms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
public class BookRoomResponse {
    private UUID bookingId;
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double price;

    void generateBookingId() {
        this.bookingId = UUID.randomUUID();
    }
}
