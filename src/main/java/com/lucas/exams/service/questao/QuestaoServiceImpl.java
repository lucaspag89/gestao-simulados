package com.lucas.exams.service.questao;

import com.lucas.exams.dto.alternativa.AlternativaDTO;
import com.lucas.exams.dto.questao.QuestaoDTO;
import com.lucas.exams.model.Alternativa;
import com.lucas.exams.model.questao.Questao;
import com.lucas.exams.repository.QuestaoRepository;
import com.lucas.exams.service.alternativa.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestaoServiceImpl implements QuestaoService {

    @Autowired
    QuestaoRepository questaoRepository;

    @Autowired
    AlternativaService alternativaService;

    @Override
    public List<QuestaoDTO> findAllByProvaId(Long id) {

        List<QuestaoDTO> questoes = new ArrayList<>();
        List<Questao> questaoList = questaoRepository.findAllByProvaId(id);

        if (questaoList.size() > 0) {
            questaoList.forEach(questao -> {
                List<AlternativaDTO> alternativas = alternativaService.findAllByQuestaoId(questao.getId());
                questoes.add(new QuestaoDTO().fromQuestao(questao, alternativas));
            });

            return questoes;
        }

        return null;
    }
}
