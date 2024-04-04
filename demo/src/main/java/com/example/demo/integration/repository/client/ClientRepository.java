package com.example.demo.integration.repository.client;

import com.example.demo.domain.colaborador.client.ClientModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    List<ClientModel> findClientModelByCep(String cep, Pageable pageable);
    List<ClientModel> findClientModelByName(String name, Pageable pageable);

}
