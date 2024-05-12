package com.example.hotel.auth;

import com.example.hotel.guest.Guest;
import com.example.hotel.guest.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class AuthenticationService {

    private final GuestRepository guestRepository;

    void register(RegisterDto registerDto) {
        Guest guest = Guest.builder()
                .username(registerDto.username())
                .password(registerDto.password())
                .confirmPassword(registerDto.confirmPassword())
                .name(registerDto.name())
                .surname(registerDto.surname())
                .email(registerDto.email())
                .phone(registerDto.phone())
                .build();

        guestRepository.save(guest);
    }
}
