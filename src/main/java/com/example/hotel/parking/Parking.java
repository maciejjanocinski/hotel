package com.example.hotel.parking;

import com.example.hotel.guest.Guest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int spotNumber;
    private double price = 50;
    private boolean isAvailable = true;

    @ManyToOne
    @JsonIgnore
    private Guest guest;

    public Parking(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}
