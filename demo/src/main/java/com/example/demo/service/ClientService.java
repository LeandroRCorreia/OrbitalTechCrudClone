package com.example.demo.service;

import com.example.demo.DTO.client.AddressDto;
import com.example.demo.DTO.client.getall.ResponsePaginationDTO;
import com.example.demo.DTO.client.put.RequestPutClientDTO;
import com.example.demo.DTO.client.put.ResponsePutClientDTO;
import com.example.demo.gateway.ConsultCepGateway;
import com.example.demo.integration.repository.client.ClientQueryRepository;
import com.example.demo.domain.colaborador.client.ClientModel;
import com.example.demo.DTO.client.get.RequestGetClientDTO;
import com.example.demo.DTO.client.get.ResponseGetClientDTO;
import com.example.demo.integration.repository.client.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientQueryRepository clientQueryRepository;

    @Autowired
    private ConsultCepGateway consultCep;

    public ResponseGetClientDTO getClient(Long id){
        ClientModel clientModel = getClientModelOrReturnNull(id);
        if (clientModel == null) return null;

        return new ResponseGetClientDTO(
                clientModel.getName(),
                clientModel.getDatabirth(),
                clientModel.getCep(),
                clientModel.getPublic_place(),
                clientModel.getLocality(),
                clientModel.getUf_state());
    }

    public Page<ResponseGetClientDTO> getPageableClient(Pageable pageable){
        Pageable pageable1 = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("databirth").descending());
        Page<ClientModel> models = clientRepository.findAll(pageable1);

        //TODO: Extract this to another specified class converter from to obj
        return models.map(clientModel ->
                new ResponseGetClientDTO(
                        clientModel.getName(),
                        clientModel.getDatabirth(),
                        clientModel.getCep(),
                        clientModel.getPublic_place(),
                        clientModel.getLocality(),
                        clientModel.getUf_state()));
    }

    public Collection<ClientModel> CustomQueryFilter(ResponsePaginationDTO req){

        Pageable pageable1 = PageRequest.of(req.getCurrent_page(), 5);


        List<ClientModel> clientModelByCep = clientRepository.findClientModelByCep("2", pageable1);


        return clientModelByCep;
    }

    @Transactional
    public ResponseGetClientDTO addClient(RequestGetClientDTO requestGetClientDTO){

        AddressDto addressDto = consultCep.consultAddress(requestGetClientDTO.cep());
        System.out.println("Address in service: ");
        System.out.println(addressDto.localidade());
        System.out.println(addressDto.cep());
        System.out.println(addressDto.error());

        //TODO: Extract this to another specified class converter from to obj
        var clientModel = new ClientModel(
                requestGetClientDTO.name(),
                requestGetClientDTO.date_birth(),
                requestGetClientDTO.cep(),
                addressDto.localidade(),
                addressDto.logradouro(),
                addressDto.uf());

        clientRepository.save(clientModel);

        return new ResponseGetClientDTO(
                clientModel.getName(),
                clientModel.getDatabirth(),
                clientModel.getCep(),
                clientModel.getPublic_place(),
                clientModel.getLocality(),
                clientModel.getUf_state());
    }

    public void deleteClient(Long id){

        clientRepository.deleteById(id);
    }

    @Transactional
    public ResponsePutClientDTO updateClient(RequestPutClientDTO requestPutClientDTO, Long id){
        ClientModel clientModel = getClientModelOrReturnNull(id);
        if (clientModel == null) return null;

        clientModel.setName(requestPutClientDTO.name());
        clientModel.setDatabirth(requestPutClientDTO.date_birth());
        //TODO: Extract this to another specified class converter from to obj
        return new ResponsePutClientDTO(clientModel.getName(), clientModel.getDatabirth());
    }

    private ClientModel getClientModelOrReturnNull(Long id) {
        Optional<ClientModel> clientModel = clientRepository.findById(id);
        //TODO: Throw an exception not found client
        return clientModel.orElse(null);
    }

}
