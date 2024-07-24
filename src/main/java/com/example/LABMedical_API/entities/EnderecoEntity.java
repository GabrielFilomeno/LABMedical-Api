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

    @NotNull(message = "O campo 'cep' é obrigatório")
    private Integer cep;

    @NotBlank(message = "O campo 'cidade' é obrigatório")
    private String cidade;

    @NotBlank(message = "O campo 'estado' é obrigatório")
    private String estado;

    @NotBlank(message = "O campo 'logradouro' é obrigatório")
    private String logradouro;

    private Integer numero;

    private String complemento;

    @NotBlank(message = "O campo 'bairro' é obrigatório")
    private String bairro;

    private String pontoReferencia;
}
