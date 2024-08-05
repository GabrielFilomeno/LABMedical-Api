package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.ExameRequest;
import com.example.LABMedical_API.dtos.ExameResponse;
import com.example.LABMedical_API.entities.ExameEntity;
import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.repositories.ExameRepository;
import com.example.LABMedical_API.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

import static com.example.LABMedical_API.mappers.ExameMapper.*;

@Service
public class ExameService {

    private final ExameRepository exameRepository;
    private final PacienteRepository pacienteRepository;
    public final JwtDecoder jwtDecoder;

    public ExameService(ExameRepository exameRepository, PacienteRepository pacienteRepository, JwtDecoder jwtDecoder) {
        this.exameRepository = exameRepository;
        this.pacienteRepository = pacienteRepository;
        this.jwtDecoder = jwtDecoder;
    }

    public ExameResponse cadastrarConsulta(ExameRequest request) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados, cadastre um paciente para cadastrar um exame");
        }

        PacienteEntity paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + request.getPacienteId()));

        return exameResponseMap(exameRepository.save(exameMap(request, paciente)));
    }

    public ExameResponse buscarConsulta(String token, Long exameId) throws AuthenticationException {

        if (exameRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há exames cadastrados");
        }

        ExameEntity exame = exameRepository.findById(exameId).orElseThrow(
                () -> new EntityNotFoundException("Exame não encontrado com o id: " + exameId)
        );

        String tokenReal = token.split(" ")[1];
        Jwt tokenDecodificado = jwtDecoder.decode(tokenReal);

        if ("PACIENTE".equals(tokenDecodificado.getClaim("scope"))) {
            String pacienteEmail = exame.getPaciente().getEmailPaciente();
            String emailToken = tokenDecodificado.getSubject();

            PacienteEntity pacienteToken = pacienteRepository.findByEmailPaciente(emailToken).orElseThrow(
                    ()-> new EntityNotFoundException("Esse usuário ainda não foi vinculado a um paciente")
            );

            if (!pacienteEmail.equals(emailToken)) {
                throw new AuthenticationException("O paciente só pode acessar seus próprios dados. Seu ID: "
                        + pacienteToken.getPacienteId()
                        + " Você tentou acessar a consulta do paciente com o ID: " + exame.getPaciente().getPacienteId()
                        + " Esses são os id's das suas consultas: "
                        + pacienteToken.getListaExameId(pacienteToken.getListaExames())
                );
            }
        }

        return exameResponseMap(exame);
    }

    public ExameResponse atualizarExame(Long exameId, ExameRequest request) {

        if (exameRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há exames cadastrados");
        }

        ExameEntity exame = exameRepository.findById(exameId).orElseThrow(
                () -> new EntityNotFoundException("Exame não encontrado com o id: " + exameId)
        );

        PacienteEntity paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + request.getPacienteId()));

        return exameResponseMap(exameRepository.save(atualizarExameMap(exame, request, paciente)));
    }

    public void excluirPaciente(Long exameId) {

        if (exameRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há exames cadastrados");
        }

        if (exameRepository.existsById(exameId)) {
            exameRepository.deleteById(exameId);
        } else {
            throw new EntityNotFoundException("Exame não encontrado com o id: " + exameId);
        }
    }
}
