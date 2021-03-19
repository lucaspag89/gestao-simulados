package com.lucas.exams.service.simulado;

import com.lucas.exams.dto.simulado.RankingDTO;
import com.lucas.exams.model.Simulado;

import java.util.List;

public interface RankingAlunosService {

    List<RankingDTO> getSimuladoRanking(Long id);

}
