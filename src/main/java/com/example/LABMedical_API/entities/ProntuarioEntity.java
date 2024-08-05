package com.example.LABMedical_API.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "prontuarios")
public class ProntuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prontuarioId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }
}
