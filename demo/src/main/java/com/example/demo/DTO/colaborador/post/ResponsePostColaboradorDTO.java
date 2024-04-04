package com.example.demo.DTO.colaborador.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ResponsePostColaboradorDTO(
        @NotNull
        @NotBlank
        String nome,
        @NotNull
        @NotBlank
        String cpf,
        @NotNull
        LocalDate data_nascimento,
        @NotNull
        @NotBlank
        String matricula_soma,
        @NotNull
        @NotBlank
        String cep,

        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        boolean ativo,
        @NotNull
        LocalDate data_cadastro) {
}
