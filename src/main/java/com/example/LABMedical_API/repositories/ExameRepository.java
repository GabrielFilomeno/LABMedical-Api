package com.example.LABMedical_API.repositories;

import com.example.LABMedical_API.entities.ExameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<ExameEntity, Long> {
}
