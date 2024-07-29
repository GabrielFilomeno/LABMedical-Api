package com.example.LABMedical_API.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaRequest {

    @NotBlank(message = "O campo 'motivoConsulta' é obrigatório")
    @Size(min = 8, max = 64)
    private String motivoConulta;

    @NotNull(message = "O campo 'dataConsulta' é obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConsulta;

    @NotNull(message = "O campo 'horaConsulta' é obrigatório")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaConsulta;

    @NotBlank(message = "O campo 'descricaoProblema' é obrigatório")
    @Size(min = 16, max = 1024)
    private String descricaoProblema;

    private String medicacaoReceitada;

    @Size(min = 16, max = 256)
    private String dosagemPrecaucoes;

    @NotNull(message = "O campo 'pacienteId' é obrigatório")
    private Long pacienteId;

    public @NotBlank(message = "O campo 'motivoConsulta' é obrigatório") @Size(min = 8, max = 64) String getMotivoConulta() {
        return motivoConulta;
    }

    public void setMotivoConulta(@NotBlank(message = "O campo 'motivoConsulta' é obrigatório") @Size(min = 8, max = 64) String motivoConulta) {
        this.motivoConulta = motivoConulta;
    }

    public @NotNull(message = "O campo 'dataConsulta' é obrigatório") LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(@NotNull(message = "O campo 'dataConsulta' é obrigatório") LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public @NotNull(message = "O campo 'horaConsulta' é obrigatório") LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(@NotNull(message = "O campo 'horaConsulta' é obrigatório") LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public @NotBlank(message = "O campo 'descricaoProblema' é obrigatório") @Size(min = 16, max = 1024) String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(@NotBlank(message = "O campo 'descricaoProblema' é obrigatório") @Size(min = 16, max = 1024) String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getMedicacaoReceitada() {
        return medicacaoReceitada;
    }

    public void setMedicacaoReceitada(String medicacaoReceitada) {
        this.medicacaoReceitada = medicacaoReceitada;
    }

    public @Size(min = 16, max = 256) String getDosagemPrecaucoes() {
        return dosagemPrecaucoes;
    }

    public void setDosagemPrecaucoes(@Size(min = 16, max = 256) String dosagemPrecaucoes) {
        this.dosagemPrecaucoes = dosagemPrecaucoes;
    }

    public @NotNull(message = "O campo 'pacienteId' é obrigatório") Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(@NotNull(message = "O campo 'pacienteId' é obrigatório") Long pacienteId) {
        this.pacienteId = pacienteId;
    }
}
