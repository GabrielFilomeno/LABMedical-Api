package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.LoginRequest;
import com.example.LABMedical_API.dtos.UsuarioRequest;
import com.example.LABMedical_API.entities.PerfilEntity;
import com.example.LABMedical_API.entities.UsuarioEntity;
import com.example.LABMedical_API.repositories.PerfilRepository;
import com.example.LABMedical_API.repositories.UsuarioRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.LABMedical_API.mappers.UsuarioMapper.usuarioRequestMap;

@Service
public class UsuarioService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;

    public UsuarioService(BCryptPasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository, PerfilService perfilService) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.perfilService = perfilService;
    }

    public void cadastrarUsuario(UsuarioRequest request) {
        if (usuarioRepository.findByEmailUsuario(request.getEmailUsuario()).isPresent()) {
            throw new EntityExistsException("Ja existe um usuário cadastrado com o email:" + request.getEmailUsuario());
        }

        PerfilEntity perfilEntity = perfilService.validaPerfil(request.getNomePerfil());

        UsuarioEntity usuarioEntity = usuarioRequestMap(request);
        usuarioEntity.setSenha(passwordEncoder.encode(request.getSenha()));
        usuarioEntity.setPerfilEntities(Set.of(perfilEntity));

        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioEntity validarUsuario(LoginRequest loginRequest) {

        UsuarioEntity usuarioEntity = usuarioRepository.findByEmailUsuario(loginRequest.getEmailUsuario())
                .orElseThrow(()-> new EntityNotFoundException("Nenhum usuário encontrado com o email: " + loginRequest.getEmailUsuario()));

        if (!passwordEncoder.matches(loginRequest.getSenha(), usuarioEntity.getPassword())) {
            throw new EntityNotFoundException("Senha incorreta para usuário com email: " + loginRequest.getEmailUsuario());
        }

        return usuarioEntity;
    }
}
