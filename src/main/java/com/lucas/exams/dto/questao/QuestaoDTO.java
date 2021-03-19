package com.lucas.exams.dto.questao;

import com.lucas.exams.dto.alternativa.AlternativaDTO;
import com.lucas.exams.model.Alternativa;
import com.lucas.exams.model.questao.Nivel;
import com.lucas.exams.model.questao.Questao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuestaoDTO implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Nivel nivel;

    @Getter
    @Setter
    private String enunciado;

    @Getter
    @Setter
    private List<AlternativaDTO> alternativas = new ArrayList<>();

    public QuestaoDTO fromQuestao(Questao questao, List<AlternativaDTO> alternativas){
        QuestaoDTO questaoDTO = new QuestaoDTO();

        questaoDTO.setId(questao.getId());
        questaoDTO.setNivel(questao.getNivel());
        questaoDTO.setEnunciado(questao.getEnunciado());
        questaoDTO.setAlternativas(alternativas);

        return questaoDTO;
    }
}
