package com.example.LABMedical_API.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "prontuarios")
public class ProntuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prontuarioId;

    private Long pacienteId;

    private String nomePaciente;

    private String convenio;

    private String contatoEmergencia;

    private String alergias;

    private String cuidados;

    private List<ExameEntity> listaExame;

    private List<ConsultaEntity> listaConsulta;

    public ProntuarioEntity() {
    }

    public ProntuarioEntity(Long pacienteId, String nomePaciente, String convenio) {
        this.pacienteId = pacienteId;
        this.nomePaciente = nomePaciente;
        this.convenio = convenio;
    }

    public ProntuarioEntity(String nomePaciente, String convenio, String contatoEmergencia, String alergias, String cuidados, List<ExameEntity> listaExame, List<ConsultaEntity> listaConsulta) {
        this.nomePaciente = nomePaciente;
        this.convenio = convenio;
        this.contatoEmergencia = contatoEmergencia;
        this.alergias = alergias;
        this.cuidados = cuidados;
        this.listaExame = listaExame;
        this.listaConsulta = listaConsulta;
    }

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

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

    public List<ExameEntity> getListaExame() {
        return listaExame;
    }

    public void setListaExame(List<ExameEntity> listaExame) {
        this.listaExame = listaExame;
    }

    public List<ConsultaEntity> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(List<ConsultaEntity> listaConsulta) {
        this.listaConsulta = listaConsulta;
    }
}
