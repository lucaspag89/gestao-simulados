package com.lucas.exams.dto.simulado;

import com.lucas.exams.model.Aluno;
import com.lucas.exams.model.RespostaAluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class RankingDTO implements Serializable {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private Long nota;

    @Getter
    @Setter
    private Long posicao;

    public RankingDTO fromRanking(Aluno aluno, Long nota) {
        RankingDTO rankingDTO = new RankingDTO();

        rankingDTO.setNome(aluno.getNome());
        rankingDTO.setNota(nota);

        return rankingDTO;
    }

    public void setPosicao() {
    }
}
