package com.lucas.exams.service.simulado;

import com.lucas.exams.dto.prova.ProvaDTO;
import com.lucas.exams.dto.questao.QuestaoDTO;
import com.lucas.exams.dto.simulado.SimuladoDTO;
import com.lucas.exams.model.Simulado;
import com.lucas.exams.repository.SimuladoRepository;
import com.lucas.exams.service.prova.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimuladoServiceImpl implements SimuladoService {

    @Autowired
    SimuladoRepository simuladoRepository;

    @Autowired
    ProvaService provaService;

    @Override
    public List<SimuladoDTO> findAllSimulados() {

        List<SimuladoDTO> simulados = new ArrayList<>();
        List<Simulado> simuladoList = simuladoRepository.findAll();

        if (simuladoList.size() > 0) {
            simuladoList.forEach(simulado -> {
                List<ProvaDTO> provas = provaService.findAllBySimuladoId(simulado.getId());
                simulados.add(new SimuladoDTO().fromSimulado(simulado, provas));
            });

            return simulados;
        }

        return null;
    }
}
