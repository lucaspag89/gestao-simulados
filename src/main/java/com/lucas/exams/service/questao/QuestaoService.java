package com.lucas.exams.service.questao;

import com.lucas.exams.dto.questao.QuestaoDTO;

import java.util.List;

public interface QuestaoService {

    List<QuestaoDTO> findAllByProvaId(Long id);

}
