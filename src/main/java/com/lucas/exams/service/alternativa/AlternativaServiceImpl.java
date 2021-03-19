package com.lucas.exams.service.alternativa;

import com.lucas.exams.dto.alternativa.AlternativaDTO;
import com.lucas.exams.dto.alternativa.AlternativaGabaritoDTO;
import com.lucas.exams.model.Alternativa;
import com.lucas.exams.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlternativaServiceImpl implements AlternativaService {

    @Autowired
    AlternativaRepository alternativaRepository;

    @Override
    public List<AlternativaDTO> findAllByQuestaoId(Long id) {

        List<AlternativaDTO> alternativas = new ArrayList<>();
        List<Alternativa> alternativaList = alternativaRepository.findAllByQuestaoId(id);

        alternativaList.forEach(alternativa -> {
            alternativas.add(new AlternativaDTO().fromAlternativa(alternativa));
        });

        return alternativas;
    }

    @Override
    public List<AlternativaGabaritoDTO> findAllByGabaritoId(Long id) {

        List<AlternativaGabaritoDTO> alternativas = new ArrayList<>();
        List<Alternativa> alternativaList = alternativaRepository.findAllByGabaritoId(id);

        alternativaList.forEach(a -> {
            AlternativaGabaritoDTO alternativa = new AlternativaGabaritoDTO();
            alternativa.setAlternativa(a.getId());

            alternativas.add(alternativa);
        });

        return alternativas;
    }
}
