package com.example.demo.DTO.client.getall;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponsePaginationDTO {
    private int current_page;
    private int per_page;
    private long total;
    private int last_page;


}
