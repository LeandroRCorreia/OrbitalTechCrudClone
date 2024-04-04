package com.example.demo.gateway;

import com.example.demo.DTO.client.AddressDto;
import com.example.demo.integration.ConsultCep;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

public interface ConsultCepGateway {

    AddressDto consultAddress(String cep);

}
