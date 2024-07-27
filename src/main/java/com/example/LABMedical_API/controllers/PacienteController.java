package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.ListarPacientesResponse;
import com.example.LABMedical_API.dtos.PacienteEnderecoRequest;
import com.example.LABMedical_API.dtos.PacienteRequest;
import com.example.LABMedical_API.dtos.PacienteResponse;
import com.example.LABMedical_API.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ListarPacientesResponse> listarPacientes(PacienteRequest filtros, Pageable paginacao){

        return pacienteService.listarPacientes(filtros, paginacao);
    }
}
