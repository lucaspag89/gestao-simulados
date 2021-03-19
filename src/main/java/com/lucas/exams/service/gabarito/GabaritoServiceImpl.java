package com.lucas.exams.service.gabarito;

import com.lucas.exams.dto.alternativa.AlternativaGabaritoDTO;
import com.lucas.exams.dto.gabarito.GabaritoProvaDTO;
import com.lucas.exams.model.Gabarito;
import com.lucas.exams.repository.GabaritoRepository;
import com.lucas.exams.service.alternativa.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GabaritoServiceImpl implements GabaritoService {

    @Autowired
    GabaritoRepository gabaritoRepository;

    @Autowired
    AlternativaService alternativaService;

    @Override
    public GabaritoProvaDTO findByProvaId(Long id) {

        Gabarito gabarito = gabaritoRepository.findFirstByProvaId(id);

        List<AlternativaGabaritoDTO> alternativaGabaritoDTOList =
                alternativaService.findAllByGabaritoId(gabarito.getId());

        if (alternativaGabaritoDTOList.size() > 0) {
            return new GabaritoProvaDTO().fromGabarito(gabarito, alternativaGabaritoDTOList);
        }

        return null;
    }
}
