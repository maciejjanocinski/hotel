package com.example.hotel.rooms;

import com.example.hotel.guest.Guest;
import com.example.hotel.guest.GuestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements ApplicationRunner {
    private final RoomRepository roomRepository;
   private final GuestRepository guestRepository;

    List<Room> getAvailableRooms() {
        return roomRepository.findByIsAvailable();
    }

    @Override
    public void run(ApplicationArguments args) {
        Room room1 = new Room(2, 100, 100);
        Room room2 = new Room(2, 101, 150);
        Room room3 = new Room(2, 102, 120);
        Room room4 = new Room(2, 103, 200);
        Room room5 = new Room(3, 104, 200);
        Room room6 = new Room(3, 105, 250);
        Room room7 = new Room(3, 106, 300);
        Room room8 = new Room(4, 107, 300);
        Room room9 = new Room(4, 108, 400);
        Room room10 = new Room(4, 109, 450);

        List<Room> rooms = List.of(room1, room2, room3, room4, room5, room6, room7, room8, room9, room10);

        rooms.forEach(room -> room.setAvailable(true));

        roomRepository.saveAll(rooms);
    }

    @Transactional
    public BookRoomResponse bookRoom(BookRoomRequest request) {
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room in not available"));
        Guest guest = guestRepository.findById(request.getGuestId())
                .orElseThrow(() -> new RuntimeException("Guest not found"));

        room.setAvailable(false);
        room.setGuest(guest);

       BookRoomResponse response = BookRoomResponse.builder()
                .roomNumber(room.getRoomNumber())
                .checkIn(request.getCheckIn())
                .checkOut(request.getCheckOut())
                .price(calculatePrice(request.getCheckIn(), request.getCheckOut(), room.getPrice()))
                .build();
        response.generateBookingId();
        return response;
    }

    private double calculatePrice(LocalDate checkIn, LocalDate checkOut, double price) {
        return price * (checkOut.getDayOfYear() - checkIn.getDayOfYear());
    }

}

