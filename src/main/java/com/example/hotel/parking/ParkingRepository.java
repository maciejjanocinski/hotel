package com.example.hotel.parking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    @Query("SELECT r FROM Parking r WHERE r.isAvailable = true")
    List<Parking> findByIsAvailable();
}
