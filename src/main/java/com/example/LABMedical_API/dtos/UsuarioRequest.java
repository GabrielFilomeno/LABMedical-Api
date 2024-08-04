package com.example.LABMedical_API.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class UsuarioRequest {

    @NotBlank(message = "O campo 'nomeUsuario' é obrigatório")
    private String nomeUsuario;

    @NotNull(message = "O campo 'emailUsuario' é obrigatório")
    @Email(message = "Endereço de e-mail inválido")
    private String emailUsuario;

    @NotNull(message = "A data de nascimento é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O CPF é obrigatório")
    @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}", message = "CPF deve ser no formato 123.456.789-12")
    private String cpf;

    @NotBlank(message = "O campo 'senhaUsuaraio' é obrigatório")
    private String senha;

    @NotBlank(message = "O campo 'nomePerfil' é obrigatório")
    private String nomePerfil;

    public @NotBlank(message = "O campo 'nomeUsuario' é obrigatório") String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(@NotBlank(message = "O campo 'nomeUsuario' é obrigatório") String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public @NotNull(message = "O campo 'emailUsuario' é obrigatório") @Email(message = "Endereço de e-mail inválido") String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(@NotNull(message = "O campo 'emailUsuario' é obrigatório") @Email(message = "Endereço de e-mail inválido") String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public @NotNull(message = "A data de nascimento é obrigatória") LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "A data de nascimento é obrigatória") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O CPF é obrigatório") @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}", message = "CPF deve ser no formato 123.456.789-12") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O CPF é obrigatório") @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}", message = "CPF deve ser no formato 123.456.789-12") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O campo 'senhaUsuaraio' é obrigatório") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "O campo 'senhaUsuaraio' é obrigatório") String senha) {
        this.senha = senha;
    }

    public @NotBlank(message = "O campo 'nomePerfil' é obrigatório") String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(@NotBlank(message = "O campo 'nomePerfil' é obrigatório") String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }
}
