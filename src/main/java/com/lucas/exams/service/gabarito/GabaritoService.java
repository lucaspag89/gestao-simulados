package com.lucas.exams.service.gabarito;

import com.lucas.exams.dto.gabarito.GabaritoProvaDTO;
import com.lucas.exams.model.Gabarito;

public interface GabaritoService {

    GabaritoProvaDTO findByProvaId(Long id);


}
