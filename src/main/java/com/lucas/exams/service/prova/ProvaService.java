package com.lucas.exams.service.prova;

import com.lucas.exams.dto.prova.ProvaDTO;

import java.util.List;

public interface ProvaService {

    List<ProvaDTO> findAllBySimuladoId(Long id);

}
