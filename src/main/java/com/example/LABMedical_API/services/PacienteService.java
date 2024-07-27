package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.EnderecoRequest;
import com.example.LABMedical_API.dtos.PacienteRequest;
import com.example.LABMedical_API.dtos.PacienteResponse;
import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import static com.example.LABMedical_API.mappers.PacienteMapper.pacienteMap;
import static com.example.LABMedical_API.mappers.PacienteMapper.pacienteResponseMap;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteResponse cadastrarPaciente(PacienteRequest pacienteRequest, EnderecoRequest enderecoRequest) {
        PacienteEntity pacienteSalvo = pacienteRepository.save(pacienteMap(pacienteRequest, enderecoRequest));

        Long pacienteId = pacienteSalvo.getPacienteId();
        Long enderecoId = pacienteSalvo.getEndereco().getEnderecoId();

        return pacienteResponseMap(pacienteRequest, enderecoRequest, pacienteId, enderecoId);
    }
}
