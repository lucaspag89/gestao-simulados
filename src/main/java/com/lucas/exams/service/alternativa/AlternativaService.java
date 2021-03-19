package com.lucas.exams.service.alternativa;

import com.lucas.exams.dto.alternativa.AlternativaDTO;
import com.lucas.exams.dto.alternativa.AlternativaGabaritoDTO;

import java.util.List;

public interface AlternativaService {

    List<AlternativaDTO> findAllByQuestaoId(Long id);

    List<AlternativaGabaritoDTO> findAllByGabaritoId(Long id);

}
