package com.example.hotel.parking;

import com.example.hotel.guest.Guest;
import com.example.hotel.guest.GuestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ParkingService implements ApplicationRunner {
    private final ParkingRepository parkingRepository;
    private final GuestRepository guestRepository;
    List<Parking> getAvailableParkingSpots() {
        return parkingRepository.findByIsAvailable();
    }

    @Override
    public void run(ApplicationArguments args) {

        Parking parking1 = new Parking(1);
        Parking parking2 = new Parking(2);
        Parking parking3 = new Parking(3);
        Parking parking4 = new Parking(4);
        Parking parking5 = new Parking(5);
        Parking parking6 = new Parking(6);
        Parking parking7 = new Parking(7);
        Parking parking8 = new Parking(8);
        Parking parking9 = new Parking(9);
        Parking parking10 = new Parking(10);

        List<Parking> parkings = List.of(parking1, parking2, parking3, parking4, parking5, parking6, parking7, parking8, parking9, parking10);

        parkings.forEach(p -> p.setAvailable(true));

        parkingRepository.saveAll(parkings);
    }

    @Transactional
    public BookParkingResponse bookParking(BookParkingRequest request) {
        Parking parking = parkingRepository.findById(request.parkingSpotId())
                .orElseThrow(() -> new RuntimeException("Parking spot is not available"));
        Guest guest = guestRepository.findById(request.guestId())
                .orElseThrow(() -> new RuntimeException("Guest not found"));

        parking.setAvailable(false);
        parking.setGuest(guest);

        BookParkingResponse response = BookParkingResponse.builder()
                .parkingSpotNumber(parking.getSpotNumber())
                .checkIn(request.checkIn())
                .checkOut(request.checkOut())
                .price(calculatePrice(request.checkIn(), request.checkOut(), parking.getPrice()))
                .build();
        response.generateBookingId();
        return response;
    }

    private double calculatePrice(LocalDate checkIn, LocalDate checkOut, double pricePerNight) {
        return pricePerNight * (checkOut.getDayOfYear() - checkIn.getDayOfYear());
    }


}
