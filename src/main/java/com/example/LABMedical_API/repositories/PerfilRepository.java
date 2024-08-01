package com.example.LABMedical_API.repositories;

import com.example.LABMedical_API.entities.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {
    Boolean existsByNomePerfil(
            String nomePerfil
    );

    Optional<PerfilEntity> findByNomePerfil(
            String nomePerfil
    );
}
