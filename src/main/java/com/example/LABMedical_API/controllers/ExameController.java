package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.ExameRequest;
import com.example.LABMedical_API.dtos.ExameResponse;
import com.example.LABMedical_API.services.ExameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

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

    @GetMapping("/{exameId}")
    @ResponseStatus(HttpStatus.OK)
    public ExameResponse buscarExame(@RequestHeader("Authorization") String token, @PathVariable Long exameId) throws AuthenticationException {
        return exameService.buscarConsulta(token, exameId);
    }

    @PutMapping("/{exameId}")
    @ResponseStatus(HttpStatus.OK)
    public ExameResponse atualizarExame(@PathVariable Long exameId, @Valid @RequestBody ExameRequest request) {
        return exameService.atualizarExame(exameId, request);
    }

    @DeleteMapping("/{exameId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirExame(@PathVariable Long exameId) {
        exameService.excluirPaciente(exameId);
    }
}
