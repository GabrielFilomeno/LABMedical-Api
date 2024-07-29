package com.example.LABMedical_API.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pacienteId;

    private String nomePaciente;

    private String generoPaciente;

    private LocalDate dataNascimento;

    @Column(unique=true)
    private String cpfPaciente;

    @Column(unique=true)
    private String rgPaciente;

    private String estadoCivil;

    private String telefonePaciente;

    @Column(unique=true)
    private String emailPaciente;

    private String naturalidade;

    private String contatoEmergencia;

    private String alergias;

    private String cuidados;

    private String convenio;

    private Integer numeroConvenio;

    private LocalDate validadeConvenio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ConsultaEntity> listaConsultas;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ExameEntity> listaExames;

    //TODO: criar atributo perfil e tratar erros relacionados


    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getGeneroPaciente() {
        return generoPaciente;
    }

    public void setGeneroPaciente(String generoPaciente) {
        this.generoPaciente = generoPaciente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getRgPaciente() {
        return rgPaciente;
    }

    public void setRgPaciente(String rgPaciente) {
        this.rgPaciente = rgPaciente;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
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

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<ConsultaEntity> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(List<ConsultaEntity> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    public List<ExameEntity> getListaExames() {
        return listaExames;
    }

    public void setListaExames(List<ExameEntity> listaExames) {
        this.listaExames = listaExames;
    }
}
