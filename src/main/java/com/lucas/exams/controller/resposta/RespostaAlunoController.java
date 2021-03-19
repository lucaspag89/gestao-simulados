package com.lucas.exams.controller.resposta;

import com.lucas.exams.dto.resposta.RespostaAlunoDTO;
import com.lucas.exams.service.respostaAluno.RespostaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/respostas")
public class RespostaAlunoController {

    @Autowired
    RespostaAlunoService respostaAlunoService;

    @PostMapping
    public ResponseEntity<RespostaAlunoDTO> createResposta(@RequestBody RespostaAlunoDTO respostaAlunoDTO) {

        try {
            respostaAlunoService.createResposta(respostaAlunoDTO);

            return new ResponseEntity<>(respostaAlunoDTO, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
