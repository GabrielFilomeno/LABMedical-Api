package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.UsuarioRequest;
import com.example.LABMedical_API.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarUsuario(@RequestBody UsuarioRequest request) {
        usuarioService.cadastrarUsuario(request);
    }
}
