package com.example.LABMedical_API.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class PacienteRequest {

    @NotBlank(message = "O campo 'nomePaciente' é obrigatório")
    @Size(min = 8, max = 64)
    private String nomePaciente;

    @NotBlank(message = "O campo 'generoPaciente' é obrigatório")
    private String generoPaciente;

    @NotNull(message = "A data de nascimento é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank   (message = "O CPF é obrigatório")
    @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}", message = "CPF deve ser no formato 123.456.789-12")
    private String cpfPaciente;

    @NotBlank(message = "O campo 'rgPaciente' é obrigatório")
    @Size(max = 20)
    private String rgPaciente;

    @NotBlank(message = "O campo 'estadoCivil' é obrigatório")
    private String estadoCivil;

    @NotBlank(message = "O campo 'telefonePaciente' é obrigatório")
    @Pattern(regexp = "^\\([0-9]{2}\\) [0-9] [0-9]{4}-[0-9]{4}$", message = "O telefone deve estar no formato (99) 9 9999-9999")
    private String telefonePaciente;

    @NotNull(message = "O campo 'emailPaciente' é obrigatório")
    @Email(message = "Endereço de e-mail inválido")
    private String emailPaciente;

    @NotBlank(message = "O campo 'naturalidade' é obrigatório")
    @Size(min = 8, max = 64)
    private String naturalidade;

    @NotBlank(message = "O campo 'contatoEmergencia' é obrigatório")
    @Pattern(regexp = "^\\([0-9]{2}\\) [0-9] [0-9]{4}-[0-9]{4}$", message = "O telefone deve estar no formato (99) 9 9999-9999")
    private String contatoEmergencia;

    private String alergias;

    private String cuidados;

    private String convenio;

    private Integer numeroConvenio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate validadeConvenio;

    public @NotBlank(message = "O campo 'nomePaciente' é obrigatório") @Size(min = 8, max = 64) String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(@NotBlank(message = "O campo 'nomePaciente' é obrigatório") @Size(min = 8, max = 64) String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public @NotBlank(message = "O campo 'generoPaciente' é obrigatório") String getGeneroPaciente() {
        return generoPaciente;
    }

    public void setGeneroPaciente(@NotBlank(message = "O campo 'generoPaciente' é obrigatório") String generoPaciente) {
        this.generoPaciente = generoPaciente;
    }

    public @NotNull(message = "A data de nascimento é obrigatória") LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "A data de nascimento é obrigatória") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank(message = "O CPF é obrigatório") @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}", message = "CPF deve ser no formato 123.456.789-12") String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(@NotBlank(message = "O CPF é obrigatório") @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}", message = "CPF deve ser no formato 123.456.789-12") String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public @NotBlank(message = "O campo 'rgPaciente' é obrigatório") @Size(max = 20) String getRgPaciente() {
        return rgPaciente;
    }

    public void setRgPaciente(@NotBlank(message = "O campo 'rgPaciente' é obrigatório") @Size(max = 20) String rgPaciente) {
        this.rgPaciente = rgPaciente;
    }

    public @NotBlank(message = "O campo 'estadoCivil' é obrigatório") String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(@NotBlank(message = "O campo 'estadoCivil' é obrigatório") String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public @NotBlank(message = "O campo 'telefonePaciente' é obrigatório") @Pattern(regexp = "^\\([0-9]{2}\\) [0-9] [0-9]{4}-[0-9]{4}$", message = "O telefone deve estar no formato (99) 9 9999-9999") String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(@NotBlank(message = "O campo 'telefonePaciente' é obrigatório") @Pattern(regexp = "^\\([0-9]{2}\\) [0-9] [0-9]{4}-[0-9]{4}$", message = "O telefone deve estar no formato (99) 9 9999-9999") String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public @NotNull(message = "O campo 'emailPaciente' é obrigatório") @Email(message = "Endereço de e-mail inválido") String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(@NotNull(message = "O campo 'emailPaciente' é obrigatório") @Email(message = "Endereço de e-mail inválido") String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public @NotBlank(message = "O campo 'naturalidade' é obrigatório") @Size(min = 8, max = 64) String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(@NotBlank(message = "O campo 'naturalidade' é obrigatório") @Size(min = 8, max = 64) String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public @NotBlank(message = "O campo 'contatoEmergencia' é obrigatório") @Pattern(regexp = "^\\([0-9]{2}\\) [0-9] [0-9]{4}-[0-9]{4}$", message = "O telefone deve estar no formato (99) 9 9999-9999") String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(@NotBlank(message = "O campo 'contatoEmergencia' é obrigatório") @Pattern(regexp = "^\\([0-9]{2}\\) [0-9] [0-9]{4}-[0-9]{4}$", message = "O telefone deve estar no formato (99) 9 9999-9999") String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Integer getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(Integer numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public LocalDate getValidadeConvenio() {
        return validadeConvenio;
    }

    public void setValidadeConvenio(LocalDate validadeConvenio) {
        this.validadeConvenio = validadeConvenio;
    }
}
