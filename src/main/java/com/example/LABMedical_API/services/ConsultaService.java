package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.ConsultaRequest;
import com.example.LABMedical_API.dtos.ConsultaResponse;
import com.example.LABMedical_API.entities.ConsultaEntity;
import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.repositories.ConsultaRepository;
import com.example.LABMedical_API.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

import static com.example.LABMedical_API.mappers.ConsultaMapper.*;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final JwtDecoder jwtDecoder;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, JwtDecoder jwtDecoder) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.jwtDecoder = jwtDecoder;
    }

    public ConsultaResponse cadastrarConsulta(ConsultaRequest request) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados, cadastre um paciente para cadastrar uma consulta");
        }

        PacienteEntity paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + request.getPacienteId()));

        return consultaResponseMap(consultaRepository.save(consultaMap(request, paciente)));
    }

    public ConsultaResponse buscarConsulta(String token, Long consultaId) throws AuthenticationException {

        if(consultaRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há consultas cadastradas");
        }

        ConsultaEntity consulta = consultaRepository.findById(consultaId).orElseThrow(
                () -> new EntityNotFoundException("Consulta não encontrada com o id: " + consultaId));

        String tokenReal = token.split(" ")[1];
        Jwt tokenDecodificado = jwtDecoder.decode(tokenReal);

        if ("PACIENTE".equals(tokenDecodificado.getClaim("scope"))) {
            String pacienteEmail = consulta.getPaciente().getEmailPaciente();
            String emailToken = tokenDecodificado.getSubject();

            PacienteEntity pacienteToken = pacienteRepository.findByEmailPaciente(emailToken).orElseThrow(
                    ()-> new EntityNotFoundException("Esse usuário ainda não foi vinculado a um paciente")
            );

            if (!pacienteEmail.equals(emailToken)) {
                throw new AuthenticationException("O paciente só pode acessar seus próprios dados. Seu ID: "
                        + pacienteToken.getPacienteId()
                        + " Você tentou acessar a consulta do paciente com o ID: " + consulta.getPaciente().getPacienteId()
                        + " Esses são os id's das suas consultas: "
                        + pacienteToken.getListaConsultaId(pacienteToken.getListaConsultas())
                );
            }
        }

        return consultaResponseMap(consulta);
    }

    public ConsultaResponse atualizarConsulta(Long consultaId, ConsultaRequest request) {
        if(consultaRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há consultas cadastradas");
        }

        ConsultaEntity consulta = consultaRepository.findById(consultaId).orElseThrow(
                () -> new EntityNotFoundException("Consulta não encontrada com o id: " + consultaId));

        PacienteEntity paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + request.getPacienteId()));

        return consultaResponseMap(consultaRepository.save(atualizarConsultaMap(consulta, request, paciente)));
    }

    public void excluirPaciente(Long consultaId) {

        if (consultaRepository.findAll().isEmpty()){
            throw new EntityNotFoundException("Não há consultas cadastradas");
        }

        if (consultaRepository.existsById(consultaId)){
            consultaRepository.deleteById(consultaId);
        } else {
            throw new EntityNotFoundException("Consulta não encontrada com o id: " + consultaId);
        }
    }
}
