package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.*;
import com.example.LABMedical_API.services.PacienteService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteResponse cadastrarPaciente(@Valid @RequestBody PacienteEnderecoRequest request) throws BadRequestException {

        return pacienteService.cadastrarPaciente(request.getPacienteRequest(), request.getEnderecoRequest());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ListarPacientesResponse> listarPacientes(PacienteRequest filtros, Pageable paginacao){

        return pacienteService.listarPacientes(filtros, paginacao);
    }

    @GetMapping("/{pacienteId}")
    @ResponseStatus(HttpStatus.OK)
    public BuscarPacienteResponse buscarPaciente(@RequestHeader("Authorization") String token, @PathVariable Long pacienteId) throws AuthenticationException {
        return pacienteService.buscarPaciente(token, pacienteId);
    }

    @PutMapping("/{pacienteId}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteResponse atualizarPaciente(@PathVariable Long pacienteId, @Valid @RequestBody PacienteEnderecoRequest request) throws BadRequestException {
        return pacienteService.atualizarPaciente(pacienteId, request.getPacienteRequest(), request.getEnderecoRequest());
    }

    @DeleteMapping("/{pacienteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPaciente(@PathVariable Long pacienteId) {
        pacienteService.excluirPaciente(pacienteId);
    }
}
