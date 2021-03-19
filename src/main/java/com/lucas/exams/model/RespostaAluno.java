package com.lucas.exams.model;

import com.lucas.exams.dto.resposta.RespostaAlunoDTO;
import com.lucas.exams.model.questao.Questao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respostaaluno")
public class RespostaAluno implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "alunoid")
    private Aluno aluno;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "simuladoid")
    private Simulado simulado;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "provaid")
    private Prova prova;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "questaoid")
    private Questao questao;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "alternativaid")
    private Alternativa alternativa;

    public RespostaAluno fromRespostaAlunoDTO(Aluno aluno, Simulado simulado, Prova prova,
                                              Questao questao, Alternativa alternativa) {

        RespostaAluno resposta = new RespostaAluno();

        resposta.setAluno(aluno);
        resposta.setSimulado(simulado);
        resposta.setProva(prova);
        resposta.setQuestao(questao);
        resposta.setAlternativa(alternativa);

        return resposta;
    }
}
