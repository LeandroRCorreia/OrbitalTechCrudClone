package com.example.demo.service;


import com.example.demo.DTO.colaborador.post.RequestPostColaboradorDTO;
import com.example.demo.DTO.colaborador.post.ResponsePostColaboradorDTO;
import com.example.demo.domain.colaborador.Colaborador;
import com.example.demo.integration.repository.colaborador.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    ColaboradorRepository colaboradorRepository;
    public Colaborador pegarColaborador(Long id) {
        return pegarColaboradorOrNull(id);
    }

    public Collection<Colaborador> listarColaboradores() {
        return colaboradorRepository.findAll();
    }

    public ResponsePostColaboradorDTO registrarColaborador(RequestPostColaboradorDTO requestPostColaboradorDTO){
        Colaborador colaborador = convertRequestToModel(requestPostColaboradorDTO);
        colaboradorRepository.save(colaborador);
        return convertModelToResponse(colaborador);
    }

    private Colaborador pegarColaboradorOrNull(Long id){
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        //TODO: Throw an exception not found client
        return colaborador.orElse(null);
    }

    private Colaborador convertRequestToModel(RequestPostColaboradorDTO requestDTO) {
        return new Colaborador(
                requestDTO.nome(),
                requestDTO.cpf(),
                requestDTO.data_nascimento(),
                requestDTO.matricula_soma(),
                requestDTO.cep(),
                requestDTO.logradouro(),
                requestDTO.numero(),
                requestDTO.complemento(),
                requestDTO.bairro(),
                requestDTO.cidade(),
                requestDTO.estado(),
                requestDTO.ativo(),
                requestDTO.data_cadastro()
        );
    }

    private ResponsePostColaboradorDTO convertModelToResponse(Colaborador colaboradorModel){
        return new ResponsePostColaboradorDTO(
                colaboradorModel.getNome(),
                colaboradorModel.getCpf(),
                colaboradorModel.getData_nascimento(),
                colaboradorModel.getMatricula_soma(),
                colaboradorModel.getCep(),
                colaboradorModel.getLogradouro(),
                colaboradorModel.getNumero(),
                colaboradorModel.getComplemento(),
                colaboradorModel.getBairro(),
                colaboradorModel.getCidade(),
                colaboradorModel.getEstado(),
                colaboradorModel.getAtivo(),
                colaboradorModel.getData_cadastro()
        );
    }

}
