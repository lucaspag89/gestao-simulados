package com.lucas.exams.dto.simulado;


import com.lucas.exams.dto.prova.ProvaDTO;
import com.lucas.exams.model.Simulado;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SimuladoDTO implements Serializable {

    @Getter
    @Setter
    private Long simulado;

    @Getter
    @Setter
    private List<ProvaDTO> provas = new ArrayList<>();

    public SimuladoDTO fromSimulado(Simulado simulado, List<ProvaDTO> provas) {
        SimuladoDTO simuladoDTO = new SimuladoDTO();

        simuladoDTO.setSimulado(simulado.getId());
        simuladoDTO.setProvas(provas);

        return simuladoDTO;
    }
}
