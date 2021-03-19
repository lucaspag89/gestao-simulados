package com.lucas.exams.dto.prova;

import com.lucas.exams.dto.questao.QuestaoDTO;
import com.lucas.exams.model.Prova;
import com.lucas.exams.service.questao.QuestaoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProvaDTO implements Serializable {

    @Autowired
    QuestaoService questaoService;

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private List<QuestaoDTO> questoes = new ArrayList<>();

    public ProvaDTO fromProva(Prova prova, List<QuestaoDTO> questoes) {
        ProvaDTO provaDTO = new ProvaDTO();

        provaDTO.setId(prova.getId());
        provaDTO.setQuestoes(questoes);

        return provaDTO;
    }
}
