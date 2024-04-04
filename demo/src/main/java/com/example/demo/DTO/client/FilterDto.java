package com.example.demo.DTO.client;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto {

    public String name;
    public String cep;

    public Boolean IsNameNull(){
        return name.isBlank() || name.isEmpty();
    }

    public Boolean IsCep(){
        return cep.isBlank() || cep.isEmpty();
    }

}
