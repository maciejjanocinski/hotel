package com.example.hotel.auth;

import lombok.Builder;

@Builder
record RegisterResponseDto(
        String jwt,
        String name
) {
}
