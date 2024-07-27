package com.example.LABMedical_API.repositories;

import com.example.LABMedical_API.entities.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    Page<PacienteEntity> findByNomePacienteContainingIgnoreCaseAndTelefonePacienteContainingAndEmailPacienteContainingIgnoreCase(
            String nomePaciente, String telefonePaciente, String emailPaciente, Pageable paginacao
    );
}
