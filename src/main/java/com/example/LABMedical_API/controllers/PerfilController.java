package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.PerfilRequest;
import com.example.LABMedical_API.services.PerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarPerfil(@RequestBody PerfilRequest request) {
        perfilService.cadastrarPerfil(request);
    }
}
