package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.PacienteEnderecoRequest;
import com.example.LABMedical_API.dtos.PacienteResponse;
import com.example.LABMedical_API.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteResponse cadastrarPaciente(@Valid @RequestBody PacienteEnderecoRequest request) {

        return pacienteService.cadastrarPaciente(request.getPacienteRequest(), request.getEnderecoRequest());
    }
}
