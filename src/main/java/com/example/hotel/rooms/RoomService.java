package com.example.hotel.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements ApplicationRunner {
    private final RoomRepository roomRepository;

    List<Room> getAvailableRooms() {
        return roomRepository.findByIsAvailable();
    }

    @Override
    public void run(ApplicationArguments args)  {
        Room room1 = new Room(2, 100);
        Room room2 = new Room(2, 150);
        Room room3 = new Room(2, 120);
        Room room4 = new Room(2, 200);
        Room room5 = new Room(3, 200);
        Room room6 = new Room(3, 250);
        Room room7 = new Room(3, 300);
        Room room8 = new Room(4, 300);
        Room room9 = new Room(4, 400);
        Room room10 = new Room(4, 450);

        List<Room> rooms = List.of(room1, room2, room3, room4, room5, room6, room7, room8, room9, room10);

        rooms.forEach(room -> room.setAvailable(true));

        roomRepository.saveAll(rooms);
    }


}
