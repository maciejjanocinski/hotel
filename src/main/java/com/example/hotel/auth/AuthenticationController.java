package com.example.hotel.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    void register(@RequestBody @Valid RegisterDto registerDto) {
        authenticationService.register(registerDto);
    }
}
