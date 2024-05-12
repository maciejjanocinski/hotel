package com.example.hotel.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/")
    List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @PostMapping("/")
    BookRoomResponse bookRoom(@RequestBody BookRoomRequest request) {
       return roomService.bookRoom(request);
    }


}
