package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.*;
import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.repositories.PacienteRepository;
import com.example.LABMedical_API.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.LABMedical_API.mappers.PacienteMapper.*;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;

    public PacienteService(PacienteRepository pacienteRepository, UsuarioRepository usuarioRepository) {
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public PacienteResponse cadastrarPaciente(PacienteRequest pacienteRequest, EnderecoRequest enderecoRequest) {
        if (usuarioRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Nenhum usuário cadastrado, cadastre um usuário para cadastrar um paciente");
        }

        if (usuarioRepository.findById(pacienteRequest.getUsuarioId()).isEmpty()) {
            throw new EntityNotFoundException("Usuário não encontrado com o id: " + pacienteRequest.getUsuarioId());
        }

        PacienteEntity pacienteSalvo = pacienteRepository.save(pacienteMap(pacienteRequest, enderecoRequest));

        Long pacienteId = pacienteSalvo.getPacienteId();
        Long enderecoId = pacienteSalvo.getEndereco().getEnderecoId();

        return pacienteResponseMap(pacienteRequest, enderecoRequest, pacienteId, enderecoId);
    }

    public Page<ListarPacientesResponse> listarPacientes(PacienteRequest filtros, Pageable paginacao) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados");
        }

        String filtroNome = filtros.getNomePaciente() != null ? filtros.getNomePaciente() : "";
        String filtroTelefone = filtros.getTelefonePaciente() != null ? filtros.getTelefonePaciente() : "";
        String filtroEmail = filtros.getEmailPaciente() != null ? filtros.getEmailPaciente() : "";

        Page<ListarPacientesResponse> resultado = listarPacientesResponseMap(pacienteRepository.findByNomePacienteContainingIgnoreCaseAndTelefonePacienteContainingAndEmailPacienteContainingIgnoreCase(
                filtroNome, filtroTelefone, filtroEmail, paginacao
        ));

        if (resultado.isEmpty()) {
            throw new EntityNotFoundException("Nenhum paciente encontrado com esses filtros");
        }

        return resultado;
    }

    public BuscarPacienteResponse buscarPaciente(Long pacienteId) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados");
        }

        PacienteEntity pacienteEntity = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + pacienteId)
        );
        return buscarPacienteMap(pacienteEntity);
    }

    public PacienteResponse atualizarPaciente(Long pacienteId, PacienteRequest request, EnderecoRequest endereco) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados");
        }

        if (usuarioRepository.findById(request.getUsuarioId()).isEmpty()) {
            throw new EntityNotFoundException("Usuário não encontrado com o id: " + request.getUsuarioId());
        }

        PacienteEntity pacienteEntity = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + pacienteId)
        );

        Long enderecoId = pacienteEntity.getEndereco().getEnderecoId();

        pacienteRepository.save(atualizarPacienteMap(pacienteEntity, request, endereco, enderecoId));

        return pacienteResponseMap(request, endereco, pacienteId, enderecoId);
    }

    public void excluirPaciente(Long pacienteId) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados");
        }

        if(pacienteRepository.existsById(pacienteId)) {
        pacienteRepository.deleteById(pacienteId);

        } else {
            throw new EntityNotFoundException("Paciente não encontrado com o id: " + pacienteId);
        }
    }
}
