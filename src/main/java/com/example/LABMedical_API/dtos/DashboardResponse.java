package com.example.LABMedical_API.dtos;

public class DashboardResponse {

    private Long quantidadePacientes;
    private Long quantidadeConsultas;
    private Long quantidadeExames;

    public Long getQuantidadePacientes() {
        return quantidadePacientes;
    }

    public void setQuantidadePacientes(Long quantidadePacientes) {
        this.quantidadePacientes = quantidadePacientes;
    }

    public Long getQuantidadeConsultas() {
        return quantidadeConsultas;
    }

    public void setQuantidadeConsultas(Long quantidadeConsultas) {
        this.quantidadeConsultas = quantidadeConsultas;
    }

    public Long getQuantidadeExames() {
        return quantidadeExames;
    }

    public void setQuantidadeExames(Long quantidadeExames) {
        this.quantidadeExames = quantidadeExames;
    }
}
