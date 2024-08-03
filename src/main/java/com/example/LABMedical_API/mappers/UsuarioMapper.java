package com.example.LABMedical_API.mappers;

import com.example.LABMedical_API.dtos.UsuarioRequest;
import com.example.LABMedical_API.dtos.UsuarioResponse;
import com.example.LABMedical_API.entities.UsuarioEntity;

public class UsuarioMapper {

    public static UsuarioEntity usuarioRequestMap(UsuarioRequest source) {
        if (source== null) return null;

        UsuarioEntity target = new UsuarioEntity();

        target.setNomeUsuario(source.getNomeUsuario());
        target.setEmailUsuario(source.getEmailUsuario());
        target.setDataNascimento(source.getDataNascimento());
        target.setCpf(source.getCpf());

        return target;
    }

    public static UsuarioResponse usuarioResponseMap(UsuarioEntity source) {
        if (source== null) return null;

        UsuarioResponse target = new UsuarioResponse();

        target.setUsuarioId(source.getUsuarioId());
        target.setNomeUsuario(source.getNomeUsuario());
        target.setEmailUsuario(source.getEmailUsuario());
        target.setDataNascimento(source.getDataNascimento());
        target.setCpf(source.getCpf());
        target.setNomePerfil(source.getPerfilEntity());

        return target;
    }
}
