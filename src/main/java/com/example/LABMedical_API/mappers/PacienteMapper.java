package com.example.LABMedical_API.mappers;

import com.example.LABMedical_API.dtos.*;
import com.example.LABMedical_API.entities.EnderecoEntity;
import com.example.LABMedical_API.entities.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class PacienteMapper {

    public PacienteMapper() {}

    public static EnderecoEntity enderecoMap(EnderecoRequest source) {
        if (source== null) return null;

        EnderecoEntity target = new EnderecoEntity();

        target.setCep(source.getCep());
        target.setCidade(source.getCidade());
        target.setEstado(source.getEstado());
        target.setLogradouro(source.getLogradouro());
        target.setNumero(source.getNumero());
        target.setComplemento(source.getComplemento());
        target.setBairro(source.getBairro());
        target.setPontoReferencia(source.getPontoReferencia());

        return target;
    }

    public static PacienteEntity pacienteMap(PacienteRequest source, EnderecoRequest endereco) {
        if (source== null) return null;

        PacienteEntity target = new PacienteEntity();

        target.setNomePaciente(source.getNomePaciente());
        target.setGeneroPaciente(source.getGeneroPaciente());
        target.setDataNascimento(source.getDataNascimento());
        target.setCpfPaciente(source.getCpfPaciente());
        target.setRgPaciente(source.getRgPaciente());
        target.setEstadoCivil(source.getEstadoCivil());
        target.setTelefonePaciente(source.getTelefonePaciente());
        target.setEmailPaciente(source.getEmailPaciente());
        target.setNaturalidade(source.getNaturalidade());
        target.setContatoEmergencia(source.getContatoEmergencia());
        target.setAlergias(source.getAlergias());
        target.setCuidados(source.getCuidados());
        target.setConvenio(source.getConvenio());
        target.setNumeroConvenio(source.getNumeroConvenio());
        target.setValidadeConvenio(source.getValidadeConvenio());
        target.setEndereco(enderecoMap(endereco));

        return target;
    }

    public static PacienteResponse pacienteResponseMap(PacienteRequest source, EnderecoRequest endereco, Long pacienteId, Long enderecoId) {
        if (source== null) return null;

        PacienteResponse target = new PacienteResponse();

        target.setPacienteId(pacienteId);
        target.setNomePaciente(source.getNomePaciente());
        target.setGeneroPaciente(source.getGeneroPaciente());
        target.setDataNascimento(source.getDataNascimento());
        target.setCpfPaciente(source.getCpfPaciente());
        target.setRgPaciente(source.getRgPaciente());
        target.setEstadoCivil(source.getEstadoCivil());
        target.setTelefonePaciente(source.getTelefonePaciente());
        target.setEmailPaciente(source.getEmailPaciente());
        target.setNaturalidade(source.getNaturalidade());
        target.setContatoEmergencia(source.getContatoEmergencia());
        target.setAlergias(source.getAlergias());
        target.setCuidados(source.getCuidados());
        target.setConvenio(source.getConvenio());
        target.setNumeroConvenio(source.getNumeroConvenio());
        target.setValidadeConvenio(source.getValidadeConvenio());
        target.setEndereco(enderecoMap(endereco));
        target.getEndereco().setEnderecoId(enderecoId);

        return target;
    }

    public static Page<ListarPacientesResponse> listarPacientesResponseMap(Page<PacienteEntity> source) {
        if (source== null) return null;

        List<ListarPacientesResponse> listaResponse = new ArrayList<>();

        for (PacienteEntity pacienteEntity : source) {

            ListarPacientesResponse listarPacientesResponse = new ListarPacientesResponse();

            listarPacientesResponse.setPacienteId(pacienteEntity.getPacienteId());
            listarPacientesResponse.setNomePaciente(pacienteEntity.getNomePaciente());
            listarPacientesResponse.setTelefonePaciente(pacienteEntity.getTelefonePaciente());
            listarPacientesResponse.setConvenio(pacienteEntity.getConvenio());

            LocalDate dataNascimento = pacienteEntity.getDataNascimento();
            LocalDate dataAtual = LocalDate.now();

            Period periodo = Period.between(dataNascimento, dataAtual);

            listarPacientesResponse.setIdade(periodo.getYears());

            listaResponse.add(listarPacientesResponse);
        }

        return new PageImpl<>(listaResponse);
    }

    public static BuscarPacienteResponse buscarPacienteMap(PacienteEntity source){
        if (source== null) return null;

        BuscarPacienteResponse target = new BuscarPacienteResponse();

        target.setPacienteId(source.getPacienteId());
        target.setNomePaciente(source.getNomePaciente());
        target.setGeneroPaciente(source.getGeneroPaciente());
        target.setDataNascimento(source.getDataNascimento());
        target.setCpfPaciente(source.getCpfPaciente());
        target.setRgPaciente(source.getRgPaciente());
        target.setEstadoCivil(source.getEstadoCivil());
        target.setTelefonePaciente(source.getTelefonePaciente());
        target.setEmailPaciente(source.getEmailPaciente());
        target.setNaturalidade(source.getNaturalidade());
        target.setContatoEmergencia(source.getContatoEmergencia());
        target.setAlergias(source.getAlergias());
        target.setCuidados(source.getCuidados());
        target.setConvenio(source.getConvenio());
        target.setNumeroConvenio(source.getNumeroConvenio());
        target.setValidadeConvenio(source.getValidadeConvenio());
        target.setEndereco(source.getEndereco());
        target.setNumeroConsultas(source.getListaConsultas().size());
        target.setNumeroExames(source.getListaExames().size());

        return target;
    }

    public static PacienteEntity atualizarPacienteMap(PacienteEntity target, PacienteRequest source, EnderecoRequest endereco, Long enderecoId){
        if (source== null) return null;

        target.setNomePaciente(source.getNomePaciente());
        target.setGeneroPaciente(source.getGeneroPaciente());
        target.setDataNascimento(source.getDataNascimento());
        target.setCpfPaciente(source.getCpfPaciente());
        target.setRgPaciente(source.getRgPaciente());
        target.setEstadoCivil(source.getEstadoCivil());
        target.setTelefonePaciente(source.getTelefonePaciente());
        target.setEmailPaciente(source.getEmailPaciente());
        target.setNaturalidade(source.getNaturalidade());
        target.setContatoEmergencia(source.getContatoEmergencia());
        target.setAlergias(source.getAlergias());
        target.setCuidados(source.getCuidados());
        target.setConvenio(source.getConvenio());
        target.setNumeroConvenio(source.getNumeroConvenio());
        target.setValidadeConvenio(source.getValidadeConvenio());
        target.setEndereco(enderecoMap(endereco));
        target.getEndereco().setEnderecoId(enderecoId);

        return target;
    }
}
