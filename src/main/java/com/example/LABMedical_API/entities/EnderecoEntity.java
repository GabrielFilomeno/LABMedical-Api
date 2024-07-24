package com.example.LABMedical_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "enderecos")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enderecoId;

    @NotNull
    private Integer cep;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String logradouro;

    private Integer numero;

    private String complemento;

    @NotBlank
    private String bairro;

    private String pontoReferencia;
}
