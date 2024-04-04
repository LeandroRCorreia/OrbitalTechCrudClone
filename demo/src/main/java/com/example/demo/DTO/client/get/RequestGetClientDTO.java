package com.example.demo.DTO.client.get;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RequestGetClientDTO(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        LocalDate date_birth,
        @NotNull
        @NotBlank
        String cep
) {
}
