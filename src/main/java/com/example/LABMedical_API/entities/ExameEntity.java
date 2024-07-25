package com.example.LABMedical_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "exames")
public class ExameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exameId;

    @NotBlank(message = "O campo 'nomeExame' é obrigatório")
    private String nomeExame;

    @NotNull(message = "O campo 'dataExame' é obrigatório")
    private LocalDate dataExame;

    @NotNull(message = "O campo 'horaExame' é obrigatório")
    private LocalTime horaExame;

    @NotBlank(message = "O campo 'tipoExame' é obrigatório")
    @Size(min = 4, max = 32)
    private String tipoExame;

    @NotBlank(message = "O campo 'laboratorio' é obrigatório")
    @Size(min = 4, max = 32)
    private String laboratorio;

    private String urlDocumento;

    @Size(min = 16, max = 1024)
    private String resultados;

    @NotNull(message = "O campo 'paciente' é obrigatório")
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    public Long getExameId() {
        return exameId;
    }

    public void setExameId(Long exameId) {
        this.exameId = exameId;
    }

    public @NotBlank(message = "O campo 'nomeExame' é obrigatório") String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(@NotBlank(message = "O campo 'nomeExame' é obrigatório") String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public @NotNull(message = "O campo 'dataExame' é obrigatório") LocalDate getDataExame() {
        return dataExame;
    }

    public void setDataExame(@NotNull(message = "O campo 'dataExame' é obrigatório") LocalDate dataExame) {
        this.dataExame = dataExame;
    }

    public @NotNull(message = "O campo 'horaExame' é obrigatório") LocalTime getHoraExame() {
        return horaExame;
    }

    public void setHoraExame(@NotNull(message = "O campo 'horaExame' é obrigatório") LocalTime horaExame) {
        this.horaExame = horaExame;
    }

    public @NotBlank(message = "O campo 'tipoExame' é obrigatório") @Size(min = 4, max = 32) String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(@NotBlank(message = "O campo 'tipoExame' é obrigatório") @Size(min = 4, max = 32) String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public @NotBlank(message = "O campo 'laboratorio' é obrigatório") @Size(min = 4, max = 32) String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(@NotBlank(message = "O campo 'laboratorio' é obrigatório") @Size(min = 4, max = 32) String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public @Size(min = 16, max = 1024) String getResultados() {
        return resultados;
    }

    public void setResultados(@Size(min = 16, max = 1024) String resultados) {
        this.resultados = resultados;
    }

    public @NotNull(message = "O campo 'paciente' é obrigatório") PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(@NotNull(message = "O campo 'paciente' é obrigatório") PacienteEntity paciente) {
        this.paciente = paciente;
    }
}
