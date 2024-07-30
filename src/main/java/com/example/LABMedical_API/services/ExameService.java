package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.ExameRequest;
import com.example.LABMedical_API.dtos.ExameResponse;
import com.example.LABMedical_API.entities.ExameEntity;
import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.repositories.ExameRepository;
import com.example.LABMedical_API.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.LABMedical_API.mappers.ExameMapper.exameMap;
import static com.example.LABMedical_API.mappers.ExameMapper.exameResponseMap;

@Service
public class ExameService {

    private final ExameRepository exameRepository;
    private final PacienteRepository pacienteRepository;

    public ExameService(ExameRepository exameRepository, PacienteRepository pacienteRepository) {
        this.exameRepository = exameRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public ExameResponse cadastrarConsulta(ExameRequest request) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados, cadastre um paciente para cadastrar um exame");
        }

        PacienteEntity paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + request.getPacienteId()));

        return exameResponseMap(exameRepository.save(exameMap(request, paciente)));
    }

    public ExameResponse buscarConsulta(Long exameId) {

        if (exameRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há exames cadastrados");
        }

        ExameEntity exame = exameRepository.findById(exameId).orElseThrow(
                () -> new EntityNotFoundException("Exame não encontrado com o id: " + exameId)
        );

        return exameResponseMap(exame);
    }
}
