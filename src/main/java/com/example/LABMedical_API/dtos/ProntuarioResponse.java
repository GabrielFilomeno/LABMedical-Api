package com.example.LABMedical_API.dtos;

import java.util.List;

public class ProntuarioResponse {

    private String nomePaciente;
    private String convenio;
    private String contatoEmergencia;
    private String alergias;
    private String cuidados;
    private List<ExameResponse> listaExames;
    private List<ConsultaResponse> listaConsultas;

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public List<ExameResponse> getListaExames() {
        return listaExames;
    }

    public void setListaExames(List<ExameResponse> listaExames) {
        this.listaExames = listaExames;
    }

    public List<ConsultaResponse> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(List<ConsultaResponse> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }
}
