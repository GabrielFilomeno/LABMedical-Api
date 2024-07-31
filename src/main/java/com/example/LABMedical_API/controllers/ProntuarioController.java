package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.ProntuarioRequest;
import com.example.LABMedical_API.dtos.ProntuarioFiltroResponse;
import com.example.LABMedical_API.dtos.ProntuarioResponse;
import com.example.LABMedical_API.services.ProntuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProntuarioController {

    private final ProntuarioService prontuarioService;

    public ProntuarioController(ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @GetMapping("/pacientes/prontuarios")
    @ResponseStatus(HttpStatus.OK)
    public Page<ProntuarioFiltroResponse> listarProntuarios(ProntuarioRequest filtros, Pageable paginacao) {
        return prontuarioService.listarProntuarios(filtros, paginacao);
    }

    @GetMapping("/pacientes/{pacienteId}/prontuarios")
    @ResponseStatus(HttpStatus.OK)
    public ProntuarioResponse buscarProntuario(@PathVariable Long pacienteId) {
        return prontuarioService.buscarProntuario(pacienteId);
    }
}
