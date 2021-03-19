package com.lucas.exams.repository;

import com.lucas.exams.model.Aluno;
import com.lucas.exams.model.RespostaAluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaAlunoRepository extends CrudRepository<RespostaAluno, Long> {

    @Query(value = "SELECT * FROM RESPOSTAALUNO " +
            "INNER JOIN QUESTAO ON QUESTAO.ID = RESPOSTAALUNO.QUESTAOID " +
            "INNER JOIN ALUNO ON ALUNO.ID = RESPOSTAALUNO.ALUNOID", nativeQuery = true)
    List<RespostaAluno> findAllJoinQuestaoJoinRespostaAluno();

}
