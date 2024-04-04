package com.example.demo.DTO.client.put;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RequestPutClientDTO(
        @NotBlank
        @NotNull
        String name,
        @NotNull
        LocalDate date_birth
) {
}
