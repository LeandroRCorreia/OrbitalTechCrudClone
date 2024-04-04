package com.example.demo.presentation;

import com.example.demo.DTO.client.put.ResponsePutClientDTO;
import com.example.demo.service.ClientService;
import com.example.demo.DTO.client.get.RequestGetClientDTO;
import com.example.demo.DTO.client.put.RequestPutClientDTO;
import com.example.demo.DTO.client.get.ResponseGetClientDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseGetClientDTO getClientById(@PathVariable Long id) {

        return clientService.getClient(id);
    }

    @GetMapping()
    public Page<ResponseGetClientDTO> getAllPageableClients(Pageable pageable){
        return clientService.getPageableClient(pageable);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseGetClientDTO addClient(@RequestBody @Valid RequestGetClientDTO clientModel){
        return clientService.addClient(clientModel);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public ResponsePutClientDTO updateClient(@RequestBody @Valid RequestPutClientDTO clientModel, @PathVariable Long id){
        return clientService.updateClient(clientModel, id);
    }

}
