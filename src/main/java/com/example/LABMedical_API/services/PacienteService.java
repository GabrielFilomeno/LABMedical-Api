package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.*;
import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.entities.PerfilEntity;
import com.example.LABMedical_API.entities.UsuarioEntity;
import com.example.LABMedical_API.repositories.PacienteRepository;
import com.example.LABMedical_API.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

import java.util.Objects;

import static com.example.LABMedical_API.mappers.PacienteMapper.*;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;
    private final JwtDecoder jwtDecoder;

    public PacienteService(PacienteRepository pacienteRepository, UsuarioRepository usuarioRepository, JwtDecoder jwtDecoder) {
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
        this.jwtDecoder = jwtDecoder;
    }

    public PacienteResponse cadastrarPaciente(PacienteRequest pacienteRequest, EnderecoRequest enderecoRequest) {
        if (usuarioRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Nenhum usuário cadastrado, cadastre um usuário para cadastrar um paciente");
        }

        UsuarioEntity usuarioEntity =  usuarioRepository.findById(pacienteRequest.getUsuarioId()).orElseThrow(
                ()-> new EntityNotFoundException("Usuário não encontrado com o id: " + pacienteRequest.getUsuarioId())
        );

        if (!"PACIENTE".equals(usuarioEntity.getPerfilEntity())) {
            throw new  RuntimeException("O usuário com id: " + usuarioEntity.getUsuarioId() +
                    " tem perfil de: " + usuarioEntity.getPerfilEntity() +
                    ". Você precisa usar o id de um usuário com perfil de PACIENTE");
        }
        if (pacienteRepository.findFirstByUsuarioEntity(usuarioEntity).isPresent()) {
            throw new RuntimeException("O usuário com o id: " + pacienteRequest.getUsuarioId() + " já esta vinculado a outro paciente");
        }

        PacienteEntity pacienteSalvo = pacienteRepository.save(pacienteMap(pacienteRequest, enderecoRequest, usuarioEntity));
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

    public BuscarPacienteResponse buscarPaciente(String token, Long pacienteId) throws AuthenticationException {
        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados");
        }

        PacienteEntity pacienteEntity = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o id: " + pacienteId));

        String tokenReal = token.split(" ")[1];
        Jwt tokenDecodificado = jwtDecoder.decode(tokenReal);

        if ("PACIENTE".equals(tokenDecodificado.getClaim("scope"))) {
            String pacienteEmail = pacienteEntity.getEmailPaciente();
            String emailToken = tokenDecodificado.getSubject();

            PacienteEntity pacienteToken = pacienteRepository.findByEmailPaciente(emailToken).orElseThrow(
                    ()-> new EntityNotFoundException("Esse usuário ainda não foi vinculado a um paciente")
            );

            if (!pacienteEmail.equals(emailToken)) {
                throw new AuthenticationException("O paciente só pode acessar seus próprios dados. Seu ID: "
                        + pacienteToken.getPacienteId()
                        + ". Você tentou usar o ID: " + pacienteId);
            }
        }

        return buscarPacienteMap(pacienteEntity);
    }

    public PacienteResponse atualizarPaciente(Long pacienteId, PacienteRequest request, EnderecoRequest endereco) {

        if (pacienteRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Não há pacientes cadastrados");
        }

        PacienteEntity pacienteEntity = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new EntityNotFoundException("Paciente não encontrado com o id: " + pacienteId)
        );

        UsuarioEntity usuarioEntity = usuarioRepository.findById(request.getUsuarioId()).orElseThrow(
                ()-> new EntityNotFoundException("Usuário não encontrado com o id: " + request.getUsuarioId())
        );

        if (!"PACIENTE".equals(usuarioEntity.getPerfilEntity())) {
            throw new  RuntimeException("O usuário com id: " + usuarioEntity.getUsuarioId() +
                    " tem perfil de: " + usuarioEntity.getPerfilEntity() +
                    ". Você precisa usar o id de um usuário com perfil de PACIENTE");
        }

        if (!Objects.equals(request.getUsuarioId(), pacienteEntity.getUsuarioEntity().getUsuarioId())) {
            if (pacienteRepository.findFirstByUsuarioEntity(usuarioEntity).isPresent()) {
                throw new RuntimeException("O usuário com o id: " + request.getUsuarioId() + " já esta vinculado a outro paciente");
            }
        }

        Long enderecoId = pacienteEntity.getEndereco().getEnderecoId();

        pacienteRepository.save(atualizarPacienteMap(pacienteEntity, request, endereco, enderecoId, usuarioEntity));

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
