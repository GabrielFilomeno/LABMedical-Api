package com.example.LABMedical_API.mappers;

import com.example.LABMedical_API.dtos.ConsultaRequest;
import com.example.LABMedical_API.dtos.ConsultaResponse;
import com.example.LABMedical_API.entities.ConsultaEntity;
import com.example.LABMedical_API.entities.PacienteEntity;

public class ConsultaMapper {

    public static ConsultaEntity consultaMap(ConsultaRequest source, PacienteEntity paciente) {
        if (source== null) return null;

        ConsultaEntity target = new ConsultaEntity();

        target.setMotivoConulta(source.getMotivoConulta());
        target.setDataConsulta(source.getDataConsulta());
        target.setHoraConsulta(source.getHoraConsulta());
        target.setDescricaoProblema(source.getDescricaoProblema());
        target.setMedicacaoReceitada(source.getMedicacaoReceitada());
        target.setDosagemPrecaucoes(source.getDosagemPrecaucoes());
        target.setPaciente(paciente);

        return target;
    }

    public static ConsultaResponse consultaResponseMap(ConsultaEntity source) {
        if (source== null) return null;

        ConsultaResponse target = new ConsultaResponse();

        target.setConsultaId(source.getConsultaId());
        target.setMotivoConulta(source.getMotivoConulta());
        target.setDataConsulta(source.getDataConsulta());
        target.setHoraConsulta(source.getHoraConsulta());
        target.setDescricaoProblema(source.getDescricaoProblema());
        target.setMedicacaoReceitada(source.getMedicacaoReceitada());
        target.setDosagemPrecaucoes(source.getDosagemPrecaucoes());
        target.setPacienteId(source.getPaciente().getPacienteId());

        return target;
    }
}
