package com.example.LABMedical_API.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExameRequest {

    @NotBlank(message = "O campo 'nomeExame' é obrigatório")
    private String nomeExame;

    @NotNull(message = "O campo 'dataExame' é obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataExame;

    @NotNull(message = "O campo 'horaExame' é obrigatório")
    @JsonFormat(pattern = "HH:mm")
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

    @NotNull(message = "O campo 'pacienteId' é obrigatório")
    private Long pacienteId;

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

    public @NotNull(message = "O campo 'pacienteId' é obrigatório") Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(@NotNull(message = "O campo 'pacienteId' é obrigatório") Long pacienteId) {
        this.pacienteId = pacienteId;
    }
}
