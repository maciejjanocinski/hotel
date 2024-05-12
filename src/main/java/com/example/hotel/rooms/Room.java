package com.example.hotel.rooms;

import com.example.hotel.guest.Guest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNumber;
    private int capacity;
    private double price;
    private boolean isAvailable = true;

    @ManyToOne
    @JsonIgnore
    private Guest guest;

    public Room(int capacity,int roomNumber, double price) {
        this.capacity = capacity;
        this.roomNumber = roomNumber;
        this.price = price;
    }
}
