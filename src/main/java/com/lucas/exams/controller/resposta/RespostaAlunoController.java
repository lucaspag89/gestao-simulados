package com.lucas.exams.controller.resposta;

import com.lucas.exams.dto.resposta.RespostaAlunoDTO;
import com.lucas.exams.model.Aluno;
import com.lucas.exams.service.aluno.AlunoService;
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

    @Autowired
    AlunoService alunoService;

    @PostMapping
    public ResponseEntity<RespostaAlunoDTO> createResposta(@RequestBody RespostaAlunoDTO respostaAlunoDTO) {

        try {
            Aluno aluno = alunoService.findByAlunoId(respostaAlunoDTO.getAlunoId());
            if (aluno == null) {
                return new ResponseEntity<>(respostaAlunoDTO, HttpStatus.NOT_FOUND);
            }

            respostaAlunoService.createResposta(respostaAlunoDTO);

            return new ResponseEntity<>(respostaAlunoDTO, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
