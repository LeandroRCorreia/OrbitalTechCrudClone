package com.example.demo.DTO.client;

public record AddressDto(
        String cep,
        String localidade,
        String logradouro,
        String uf,
        Boolean error
        ) {
}
