package com.example.LABMedical_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consultas")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultaId;

    @NotBlank(message = "O campo 'motivoConsulta' é obrigatório")
    @Size(min = 8, max = 64)
    private String motivoConulta;

    @NotNull(message = "O campo 'dataConsulta' é obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataConsulta;

    @NotNull(message = "O campo 'horaConsulta' é obrigatório")
    private LocalTime horaConsulta;

    @NotBlank(message = "O campo 'descricaoProblema' é obrigatório")
    @Size(min = 16, max = 1024)
    private String descricaoProblema;

    private String medicacaoReceitada;

    @Size(min = 16, max = 256)
    private String dosagemPrecaucoes;

    @NotNull(message = "O campo 'paciente' é obrigatório")
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public @NotBlank @Size(min = 8, max = 64) String getMotivoConulta() {
        return motivoConulta;
    }

    public void setMotivoConulta(@NotBlank @Size(min = 8, max = 64) String motivoConulta) {
        this.motivoConulta = motivoConulta;
    }

    public @NotNull LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(@NotNull LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public @NotNull LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(@NotNull LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public @NotBlank @Size(min = 16, max = 1024) String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(@NotBlank @Size(min = 16, max = 1024) String descricaoProblema) {
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

    public @NotNull PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(@NotNull PacienteEntity paciente) {
        this.paciente = paciente;
    }
}
