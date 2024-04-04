package com.example.demo.DTO.client.get;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ResponseGetClientDTO(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        LocalDate date_birth,
        String cep,
        String public_place,
        String locality,
        String uf_state
) {

}
