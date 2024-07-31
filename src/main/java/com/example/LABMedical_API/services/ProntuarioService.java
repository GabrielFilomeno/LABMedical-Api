package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.ProntuarioRequest;
import com.example.LABMedical_API.dtos.ProntuarioFiltroResponse;
import com.example.LABMedical_API.dtos.ProntuarioResponse;
import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.LABMedical_API.mappers.ProntuarioMapper.prontuarioFiltroResponseMap;
import static com.example.LABMedical_API.mappers.ProntuarioMapper.prontuarioResponseMap;

@Service
public class ProntuarioService {

    private final PacienteRepository pacienteRepository;

    public ProntuarioService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Page<ProntuarioFiltroResponse> listarProntuarios(ProntuarioRequest filtros, Pageable paginacao) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados");
        }

        String filtroNome = filtros.getNomePaciente() != null ? filtros.getNomePaciente() : "";
        Long filtroPacienteId = filtros.getPacienteId();

        Page<ProntuarioFiltroResponse> resultado;

        if (filtroPacienteId != null) {
            resultado = prontuarioFiltroResponseMap(pacienteRepository.findByNomePacienteContainingIgnoreCaseAndPacienteId(
                    filtroNome, filtroPacienteId, paginacao
            ));
        } else {

            resultado = prontuarioFiltroResponseMap(pacienteRepository.findByNomePacienteContainingIgnoreCase(
                    filtroNome, paginacao
            ));
        }

        if (resultado.isEmpty()) {
            throw new EntityNotFoundException("Nenhum paciente encontrado com esses filtros");
        }

        return resultado;
    }

    public ProntuarioResponse buscarProntuario(Long pacienteId) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados");
        }

        PacienteEntity pacienteEntity = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + pacienteId)
        );

        return prontuarioResponseMap(pacienteEntity);
    }
}
