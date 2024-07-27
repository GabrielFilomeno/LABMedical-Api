package com.example.LABMedical_API.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class PacienteEnderecoRequest {

    @NotNull
    @Valid
    private PacienteRequest pacienteRequest;
    @NotNull
    @Valid
    private EnderecoRequest enderecoRequest;

    public @NotNull @Valid PacienteRequest getPacienteRequest() {
        return pacienteRequest;
    }

    public void setPacienteRequest(@NotNull @Valid PacienteRequest pacienteRequest) {
        this.pacienteRequest = pacienteRequest;
    }

    public @NotNull @Valid EnderecoRequest getEnderecoRequest() {
        return enderecoRequest;
    }

    public void setEnderecoRequest(@NotNull @Valid EnderecoRequest enderecoRequest) {
        this.enderecoRequest = enderecoRequest;
    }
}
