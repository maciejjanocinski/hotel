package com.example.hotel.parking;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping("/")
    List<Parking> getParkingSpots() {
        return parkingService.getAvailableParkingSpots();
    }

    @PostMapping("/")
    BookParkingResponse bookParkingSpot(@RequestBody BookParkingRequest request) {
        return parkingService.bookParking(request);
    }

}
