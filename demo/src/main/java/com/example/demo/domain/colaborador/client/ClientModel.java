package com.example.demo.domain.colaborador.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name="client")
@EqualsAndHashCode(of = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    LocalDate databirth;

    String cep;

    String public_place;
    String locality;
    String uf_state;

    public ClientModel(
            String name,
            LocalDate databirth,
            String cep,
            String public_place,
            String locality,
            String uf_state) {
        this.name = name;
        this.databirth = databirth;
        this.cep = cep;
        this.public_place = public_place;
        this.locality = locality;
        this.uf_state = uf_state;
    }

}
