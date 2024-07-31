package com.example.LABMedical_API.mappers;

import com.example.LABMedical_API.dtos.ProntuarioResponse;
import com.example.LABMedical_API.entities.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class ProntuarioMapper {

    public static Page<ProntuarioResponse> prontuarioResponseMap(Page<PacienteEntity> source) {
        if (source== null) return null;

        List<ProntuarioResponse> listaResponse = new ArrayList<>();

        for (PacienteEntity pacienteEntity : source) {

            ProntuarioResponse prontuarioResponse = new ProntuarioResponse();

            prontuarioResponse.setNomePaciente(pacienteEntity.getNomePaciente());
            prontuarioResponse.setPacienteId(pacienteEntity.getPacienteId());
            prontuarioResponse.setConvenio(pacienteEntity.getConvenio());

            listaResponse.add(prontuarioResponse);
        }

        return new PageImpl<>(listaResponse);
    }
}
