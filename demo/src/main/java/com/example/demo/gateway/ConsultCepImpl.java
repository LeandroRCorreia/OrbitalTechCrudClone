package com.example.demo.gateway;


import com.example.demo.DTO.client.AddressDto;
import com.example.demo.integration.ConsultCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultCepImpl implements ConsultCepGateway {

    @Autowired
    ConsultCep consultCepGateway;

    @Override
    public AddressDto consultAddress(String cep) {
        AddressDto addressDto = consultCepGateway.consultAddress(cep);
        System.out.println("Address in consultCep: ");
        System.out.println(addressDto.localidade());
        System.out.println(addressDto.cep());
        System.out.println(addressDto.error());

        //TODO: Throw an exception <cep not found 404 /> or <cep format invalid 400 BAD REQUEST/>
//        if(addressDto.error()) return null;


        return addressDto;
    }
}
