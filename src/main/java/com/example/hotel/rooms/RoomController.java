package com.example.hotel.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/")
    List<Room> getBodyMetrics() {
        return roomService.getAvailableRooms();
    }


}
