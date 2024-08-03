package com.example.LABMedical_API.repositories;

import com.example.LABMedical_API.entities.PacienteEntity;
import com.example.LABMedical_API.entities.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    Page<PacienteEntity> findByNomePacienteContainingIgnoreCaseAndTelefonePacienteContainingAndEmailPacienteContainingIgnoreCase(
            String nomePaciente, String telefonePaciente, String emailPaciente, Pageable paginacao
    );

    Page<PacienteEntity> findByNomePacienteContainingIgnoreCaseAndPacienteId(
            String nomePaciente, Long pacienteId, Pageable paginacao
    );

    Page<PacienteEntity> findByNomePacienteContainingIgnoreCase(
            String nomePaciente, Pageable paginacao
    );

    Optional<PacienteEntity> findByEmailPaciente(String emailPaciente);

    Optional<PacienteEntity> findFirstByUsuarioEntity(UsuarioEntity usuarioEntity);
}
