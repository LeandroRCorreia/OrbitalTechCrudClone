package com.example.demo.presentation;

import com.example.demo.DTO.colaborador.post.RequestPostColaboradorDTO;
import com.example.demo.DTO.colaborador.post.ResponsePostColaboradorDTO;
import com.example.demo.domain.colaborador.Colaborador;
import com.example.demo.service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    ColaboradorService colaboradorService;

    @GetMapping("/{id}")
    private Colaborador GetClientById(@PathVariable Long id){
        return colaboradorService.pegarColaborador(id);
    }

    @GetMapping()
    private Collection<Colaborador> GetAllClients(){
        return colaboradorService.listarColaboradores();
    }

    @PostMapping
    private ResponsePostColaboradorDTO registrarColaborador(
            @Valid @RequestBody
            RequestPostColaboradorDTO colaborador){
        return colaboradorService.registrarColaborador(colaborador);
    }

}
