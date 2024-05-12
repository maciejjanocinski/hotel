package com.example.hotel.rooms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRoomRequest {
    Long guestId;
    Long roomId;
    LocalDate checkIn;
    LocalDate checkOut;
}
