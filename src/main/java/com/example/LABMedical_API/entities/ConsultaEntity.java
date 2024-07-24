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

    @NotBlank
    @Size(min = 8, max = 64)
    private String motivoConulta;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataConsulta;

    @NotNull
    private LocalTime horaConsulta;

    @NotBlank
    @Size(min = 16, max = 1024)
    private String descricaoProblema;

    private String medicacaoReceitada;

    @Size(min = 16, max = 256)
    private String dosagemPrecaucoes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;
}
