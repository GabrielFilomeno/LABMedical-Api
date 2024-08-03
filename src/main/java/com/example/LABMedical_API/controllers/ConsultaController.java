package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.ConsultaRequest;
import com.example.LABMedical_API.dtos.ConsultaResponse;
import com.example.LABMedical_API.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

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

    @GetMapping("/{consultaId}")
    @ResponseStatus(HttpStatus.OK)
    public ConsultaResponse buscarConsulta(@RequestHeader("Authorization") String token, @PathVariable Long consultaId) throws AuthenticationException {
        return consultaService.buscarConsulta(token, consultaId);
    }

    @PutMapping("/{consultaId}")
    @ResponseStatus(HttpStatus.OK)
    public ConsultaResponse atualizarConsulta(@PathVariable Long consultaId, @Valid @RequestBody ConsultaRequest request) {
        return consultaService.atualizarConsulta(consultaId, request);
    }

    @DeleteMapping("/{consultaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirConsulta(@PathVariable Long consultaId) {
        consultaService.excluirPaciente(consultaId);
    }
}
