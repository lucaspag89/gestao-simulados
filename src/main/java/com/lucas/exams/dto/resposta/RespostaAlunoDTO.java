package com.lucas.exams.dto.resposta;

import com.lucas.exams.model.Alternativa;
import com.lucas.exams.model.Aluno;
import com.lucas.exams.model.Prova;
import com.lucas.exams.model.Simulado;
import com.lucas.exams.model.questao.Questao;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class RespostaAlunoDTO implements Serializable {

    @Getter
    @Setter
    private Long alunoId;

    @Getter
    @Setter
    private Long simuladoId;

    @Getter
    @Setter
    private Long provaId;

    @Getter
    @Setter
    private Long questaoId;

    @Getter
    @Setter
    private Long alternativaId;

}
