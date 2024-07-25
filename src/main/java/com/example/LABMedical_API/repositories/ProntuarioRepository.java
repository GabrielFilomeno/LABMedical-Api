package com.example.LABMedical_API.repositories;

import com.example.LABMedical_API.entities.ProntuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<ProntuarioEntity, Long> {
}
