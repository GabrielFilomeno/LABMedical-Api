package com.example.LABMedical_API.services;

import com.example.LABMedical_API.dtos.LoginRequest;
import com.example.LABMedical_API.dtos.UsuarioRequest;
import com.example.LABMedical_API.dtos.UsuarioResponse;
import com.example.LABMedical_API.entities.PerfilEntity;
import com.example.LABMedical_API.entities.UsuarioEntity;
import com.example.LABMedical_API.repositories.UsuarioRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.example.LABMedical_API.mappers.UsuarioMapper.usuarioRequestMap;
import static com.example.LABMedical_API.mappers.UsuarioMapper.usuarioResponseMap;

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

    public UsuarioResponse cadastrarUsuario(UsuarioRequest request) {

        PerfilEntity perfilEntity = perfilService.validaPerfil(request.getNomePerfil());

        UsuarioEntity usuarioEntity = usuarioRequestMap(request);
        usuarioEntity.setSenha(passwordEncoder.encode(request.getSenha()));
        usuarioEntity.setPerfilEntities(Set.of(perfilEntity));

        return usuarioResponseMap(usuarioRepository.save(usuarioEntity));
    }

    public UsuarioEntity validarUsuario(LoginRequest loginRequest) throws BadRequestException {

        UsuarioEntity usuarioEntity = usuarioRepository.findByEmailUsuario(loginRequest.getEmailUsuario())
                .orElseThrow(()-> new BadRequestException("Dados ausentes ou incorretos."));

        if (!passwordEncoder.matches(loginRequest.getSenha(), usuarioEntity.getPassword())) {
            throw new BadRequestException("Dados ausentes ou incorretos.");
        }

        return usuarioEntity;
    }
}
