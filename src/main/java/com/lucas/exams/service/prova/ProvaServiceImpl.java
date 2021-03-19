package com.lucas.exams.service.prova;

import com.lucas.exams.dto.prova.ProvaDTO;
import com.lucas.exams.dto.questao.QuestaoDTO;
import com.lucas.exams.model.Prova;
import com.lucas.exams.repository.ProvaRepository;
import com.lucas.exams.service.questao.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvaServiceImpl implements ProvaService {

    @Autowired
    ProvaRepository provaRepository;

    @Autowired
    QuestaoService questaoService;

    @Override
    public List<ProvaDTO> findAllBySimuladoId(Long id) {

        List<ProvaDTO> provas = new ArrayList<>();
        List<Prova> provaList = provaRepository.findAllBySimuladoId(id);

        if (provaList.size() > 0) {
            provaList.forEach(prova -> {
                List<QuestaoDTO> questoes = questaoService.findAllByProvaId(prova.getId());
                provas.add(new ProvaDTO().fromProva(prova, questoes));
            });

            return provas;
        }

        return null;
    }
}
