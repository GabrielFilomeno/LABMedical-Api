package com.example.LABMedical_API.controllers;

import com.example.LABMedical_API.dtos.LoginRequest;
import com.example.LABMedical_API.dtos.LoginResponse;
import com.example.LABMedical_API.entities.UsuarioEntity;
import com.example.LABMedical_API.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UsuarioService usuarioService;

    public TokenController(JwtEncoder jwtEncoder, UsuarioService usuarioService) {
        this.jwtEncoder = jwtEncoder;
        this.usuarioService = usuarioService;
    }

    private static final long TEMPO_EXPIRACAO = 36000L;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse>gerarToken(@RequestBody LoginRequest loginRequest) {

        UsuarioEntity usuarioEntity = usuarioService.validarUsuario(loginRequest);

        Instant agora = Instant.now();

        String scope = usuarioEntity.getAuthorities()
                .stream().map(autority -> autority.getAuthority())
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(agora)
                .expiresAt(agora.plusSeconds(TEMPO_EXPIRACAO))
                .subject(usuarioEntity.getUsername())
                .claim("scope", scope)
                .build();

        var valorJwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(valorJwt, TEMPO_EXPIRACAO));
    }


}
