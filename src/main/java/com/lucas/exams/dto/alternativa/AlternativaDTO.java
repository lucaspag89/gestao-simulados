package com.lucas.exams.dto.alternativa;

import com.lucas.exams.model.Alternativa;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class AlternativaDTO implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String opcao;

    public AlternativaDTO fromAlternativa(Alternativa alternativa){
        AlternativaDTO alternativaDTO = new AlternativaDTO();

        alternativaDTO.setId(alternativa.getId());
        alternativaDTO.setOpcao(alternativa.getOpcao());

        return alternativaDTO;
    }
}
