package com.example.LABMedical_API.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaResponse {

    private Long consultaId;
    private String motivoConulta;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private String descricaoProblema;
    private String medicacaoReceitada;
    private String dosagemPrecaucoes;
    private Long pacienteId;

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public String getMotivoConulta() {
        return motivoConulta;
    }

    public void setMotivoConulta(String motivoConulta) {
        this.motivoConulta = motivoConulta;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getMedicacaoReceitada() {
        return medicacaoReceitada;
    }

    public void setMedicacaoReceitada(String medicacaoReceitada) {
        this.medicacaoReceitada = medicacaoReceitada;
    }

    public String getDosagemPrecaucoes() {
        return dosagemPrecaucoes;
    }

    public void setDosagemPrecaucoes(String dosagemPrecaucoes) {
        this.dosagemPrecaucoes = dosagemPrecaucoes;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
}
