package com.example.hotel.guest;

import com.example.hotel.parking.Parking;
import com.example.hotel.rooms.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String confirmPassword;
    String name;
    String surname;
    String email;
    String phone;
    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Room> room;
    @OneToMany(mappedBy = "guest", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Parking> parking;
}

