package com.example.LABMedical_API.mappers;

import com.example.LABMedical_API.dtos.ConsultaResponse;
import com.example.LABMedical_API.dtos.ExameResponse;
import com.example.LABMedical_API.dtos.ProntuarioFiltroResponse;
import com.example.LABMedical_API.dtos.ProntuarioResponse;
import com.example.LABMedical_API.entities.ConsultaEntity;
import com.example.LABMedical_API.entities.ExameEntity;
import com.example.LABMedical_API.entities.PacienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.example.LABMedical_API.mappers.ConsultaMapper.consultaResponseMap;
import static com.example.LABMedical_API.mappers.ExameMapper.exameResponseMap;

public class ProntuarioMapper {

    public static Page<ProntuarioFiltroResponse> prontuarioFiltroResponseMap(Page<PacienteEntity> source) {
        if (source== null) return null;

        List<ProntuarioFiltroResponse> listaResponse = new ArrayList<>();

        for (PacienteEntity pacienteEntity : source) {

            ProntuarioFiltroResponse prontuarioFiltroResponse = new ProntuarioFiltroResponse();

            prontuarioFiltroResponse.setNomePaciente(pacienteEntity.getNomePaciente());
            prontuarioFiltroResponse.setPacienteId(pacienteEntity.getPacienteId());
            prontuarioFiltroResponse.setConvenio(pacienteEntity.getConvenio());

            listaResponse.add(prontuarioFiltroResponse);
        }

        return new PageImpl<>(listaResponse);
    }

    public static ProntuarioResponse prontuarioResponseMap(PacienteEntity source) {
        if (source== null) return null;

        ProntuarioResponse target = new ProntuarioResponse();

        target.setNomePaciente(source.getNomePaciente());
        target.setConvenio(source.getConvenio());
        target.setContatoEmergencia(source.getContatoEmergencia());
        target.setAlergias(source.getAlergias());
        target.setCuidados(source.getCuidados());

        List<ExameResponse> listaExames = new ArrayList<>();

        for (ExameEntity exameEntity : source.getListaExames()) {
            ExameResponse exameResponse = exameResponseMap(exameEntity);

            listaExames.add(exameResponse);
        }

        List<ConsultaResponse> listaConsultas = new ArrayList<>();

        for (ConsultaEntity consultaEntity : source.getListaConsultas()) {
            ConsultaResponse consultaResponse = consultaResponseMap(consultaEntity);

            listaConsultas.add(consultaResponse);
        }

        listaExames.sort(Comparator.comparing(ExameResponse::getDataExame));
        listaConsultas.sort((Comparator.comparing(ConsultaResponse::getDataConsulta)));

        target.setListaExames(listaExames);
        target.setListaConsultas(listaConsultas);

        return target;
    }
}
