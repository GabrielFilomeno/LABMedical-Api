package com.example.LABMedical_API.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnderecoRequest {

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

    public @NotNull(message = "O campo 'cep' é obrigatório") Integer getCep() {
        return cep;
    }

    public void setCep(@NotNull(message = "O campo 'cep' é obrigatório") Integer cep) {
        this.cep = cep;
    }

    public @NotBlank(message = "O campo 'cidade' é obrigatório") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank(message = "O campo 'cidade' é obrigatório") String cidade) {
        this.cidade = cidade;
    }

    public @NotBlank(message = "O campo 'estado' é obrigatório") String getEstado() {
        return estado;
    }

    public void setEstado(@NotBlank(message = "O campo 'estado' é obrigatório") String estado) {
        this.estado = estado;
    }

    public @NotBlank(message = "O campo 'logradouro' é obrigatório") String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(@NotBlank(message = "O campo 'logradouro' é obrigatório") String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public @NotBlank(message = "O campo 'bairro' é obrigatório") String getBairro() {
        return bairro;
    }

    public void setBairro(@NotBlank(message = "O campo 'bairro' é obrigatório") String bairro) {
        this.bairro = bairro;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }
}
