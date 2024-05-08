package com.example.hotel.auth;

import com.example.hotel.client.Client;
import com.example.hotel.client.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class AuthenticationService {

    private final ClientRepository clientRepository;

    void register(RegisterDto registerDto) {
        Client client = Client.builder()
                .username(registerDto.username())
                .password(registerDto.password())
                .confirmPassword(registerDto.confirmPassword())
                .name(registerDto.name())
                .surname(registerDto.surname())
                .email(registerDto.email())
                .phone(registerDto.phone())
                .build();

        clientRepository.save(client);
    }
}
