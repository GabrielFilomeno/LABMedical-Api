package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.ConsultaRequest;
import com.example.LABMedical_API.dtos.ConsultaResponse;
import com.example.LABMedical_API.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsultaResponse cadastrarConsulta(@Valid @RequestBody ConsultaRequest request) {
        return consultaService.cadastrarConsulta(request);
    }
}
