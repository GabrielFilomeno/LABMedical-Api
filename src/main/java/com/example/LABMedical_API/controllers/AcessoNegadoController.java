package com.example.LABMedical_API.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acesso-negado")
public class AcessoNegadoController {

    @GetMapping
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String acessoNegado(){
        return "Você não tem permissão para acessar esse endereço";
    }
}
