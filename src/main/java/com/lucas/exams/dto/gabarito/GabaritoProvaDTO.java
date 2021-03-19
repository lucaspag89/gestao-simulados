package com.lucas.exams.dto.gabarito;

import com.lucas.exams.dto.alternativa.AlternativaGabaritoDTO;
import com.lucas.exams.model.Gabarito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class GabaritoProvaDTO implements Serializable {

    @Getter
    @Setter
    private Long prova;

    @Getter
    @Setter
    private List<AlternativaGabaritoDTO> gabarito = new ArrayList<>();

    public GabaritoProvaDTO fromGabarito(Gabarito gabarito, List<AlternativaGabaritoDTO> alternativaGabaritoDTOList){
        GabaritoProvaDTO gabaritoProvaDTO = new GabaritoProvaDTO();

        gabaritoProvaDTO.setProva(gabarito.getProva().getId());
        gabaritoProvaDTO.setGabarito(alternativaGabaritoDTOList);

        return gabaritoProvaDTO;
    }
}
