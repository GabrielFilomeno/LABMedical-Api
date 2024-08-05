package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.UsuarioRequest;
import com.example.LABMedical_API.dtos.UsuarioResponse;
import com.example.LABMedical_API.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse cadastrarUsuario(@Valid @RequestBody UsuarioRequest request) {
        return usuarioService.cadastrarUsuario(request);
    }
}
