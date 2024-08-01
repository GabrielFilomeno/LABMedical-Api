package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.PerfilRequest;
import com.example.LABMedical_API.entities.PerfilEntity;
import com.example.LABMedical_API.repositories.PerfilRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public void cadastrarPerfil(PerfilRequest request) {
        if (perfilRepository.existsByNomePerfil(request.getNomePerfil())) {
            throw new EntityExistsException("Ja existe um perfil cadastrado com o nome: " + request.getNomePerfil());
        } else {
            PerfilEntity perfilEntity = new PerfilEntity();
            perfilEntity.setNomePerfil(request.getNomePerfil());
            perfilRepository.save(perfilEntity);
        }
    }
}
