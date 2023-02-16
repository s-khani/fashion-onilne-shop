package com.example.FashionOnlineShop.domain;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamps,
        int status,
        String message,
        String path
) {
}
