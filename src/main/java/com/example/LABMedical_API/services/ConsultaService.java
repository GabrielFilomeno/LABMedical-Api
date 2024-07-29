package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.ConsultaRequest;
import com.example.LABMedical_API.dtos.ConsultaResponse;
import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.repositories.ConsultaRepository;
import com.example.LABMedical_API.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.LABMedical_API.mappers.ConsultaMapper.consultaMap;
import static com.example.LABMedical_API.mappers.ConsultaMapper.consultaResponseMap;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public ConsultaResponse cadastrarConsulta(ConsultaRequest request) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados, cadastre um paciente para cadastrar uma consulta");
        }

        PacienteEntity paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + request.getPacienteId()));

        return consultaResponseMap(consultaRepository.save(consultaMap(request, paciente)));
    }
}
