package com.example.demo.integration;

import com.example.demo.DTO.client.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "AddressDto", url = "https://viacep.com.br/ws/")
public interface ConsultCep {
    @GetMapping(value = "{cep}/json/")
    AddressDto consultAddress(@PathVariable("cep") String cep);

}
