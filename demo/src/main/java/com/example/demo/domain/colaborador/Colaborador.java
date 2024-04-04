package com.example.demo.domain.colaborador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@EqualsAndHashCode(of = "cpf")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Colaborador {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String cpf;

    LocalDate data_nascimento;

    String matricula_soma;

    String cep;
    String logradouro;
    String numero;
    String complemento;
    String bairro;
    String cidade;
    String estado;
    Boolean ativo;

    LocalDate data_cadastro;

    public Colaborador(
            String nome, String cpf, LocalDate dataNascimento, String matriculaSoma, String cep,
            String logradouro, String numero, String complemento, String bairro,
            String cidade, String estado, boolean ativo, LocalDate dataCadastro
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = dataNascimento;
        this.matricula_soma = matriculaSoma;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.ativo = ativo;
        this.data_cadastro = dataCadastro;
    }
}
