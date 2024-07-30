package com.example.LABMedical_API.mappers;

import com.example.LABMedical_API.dtos.ExameRequest;
import com.example.LABMedical_API.dtos.ExameResponse;
import com.example.LABMedical_API.entities.ExameEntity;
import com.example.LABMedical_API.entities.PacienteEntity;

public class ExameMapper {

    public static ExameEntity exameMap(ExameRequest source, PacienteEntity paciente) {
        if (source== null) return null;

        ExameEntity target = new ExameEntity();

        target.setNomeExame(source.getNomeExame());
        target.setDataExame(source.getDataExame());
        target.setHoraExame(source.getHoraExame());
        target.setTipoExame(source.getTipoExame());
        target.setLaboratorio(source.getLaboratorio());
        target.setUrlDocumento(source.getUrlDocumento());
        target.setResultados(source.getResultados());
        target.setPaciente(paciente);

        return target;
    }

    public static ExameResponse exameResponseMap(ExameEntity source) {
        if (source== null) return null;

        ExameResponse target = new ExameResponse();

        target.setExameId(source.getExameId());
        target.setNomeExame(source.getNomeExame());
        target.setDataExame(source.getDataExame());
        target.setHoraExame(source.getHoraExame());
        target.setTipoExame(source.getTipoExame());
        target.setLaboratorio(source.getLaboratorio());
        target.setUrlDocumento(source.getUrlDocumento());
        target.setResultados(source.getResultados());
        target.setPacienteId(source.getPaciente().getPacienteId());

        return target;
    }
}
