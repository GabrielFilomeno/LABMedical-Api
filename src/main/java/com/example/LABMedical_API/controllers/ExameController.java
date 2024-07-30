package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.ExameRequest;
import com.example.LABMedical_API.dtos.ExameResponse;
import com.example.LABMedical_API.services.ExameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exames")
public class ExameController {

    private final ExameService exameService;

    public ExameController(ExameService exameService) {
        this.exameService = exameService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExameResponse cadastrarExame(@Valid @RequestBody ExameRequest request) {
        return exameService.cadastrarConsulta(request);
    }
}
