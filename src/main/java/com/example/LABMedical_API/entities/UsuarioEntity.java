package com.example.LABMedical_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @NotBlank(message = "O campo 'nomeUsuario' é obrigatório")
    private String nomeUsuario;

    @NotNull(message = "O campo 'emailUsuario' é obrigatório")
    @Email(message = "Endereço de e-mail inválido")
    @Column(unique=true)
    private String emailUsuario;

    @NotNull(message = "A data de nascimento é obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataNascimento;

    @NotNull(message = "O CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Column(unique=true)
    private String cpf;

    @NotBlank(message = "O campo 'senhaUsuaraio' é obrigatório")
    private String senha;

    //TODO: criar atributo perfil


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

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

    public @NotNull(message = "A data de nascimento é obrigatória") String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "A data de nascimento é obrigatória") String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O CPF é obrigatório") @CPF(message = "CPF inválido") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O CPF é obrigatório") @CPF(message = "CPF inválido") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O campo 'senhaUsuaraio' é obrigatório") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "O campo 'senhaUsuaraio' é obrigatório") String senha) {
        this.senha = senha;
    }
}
