package com.example.demo.integration.repository.client;


import com.example.demo.DTO.client.FilterDto;
import com.example.demo.domain.colaborador.client.ClientModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<ClientModel> customQueryByParams(FilterDto filterDto) {
        StringBuilder query = new StringBuilder("from Client t where t.cep = :cep");

        if(filterDto.IsCep()){

        }


        return null;
    }

}
