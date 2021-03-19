package com.lucas.exams.repository;

import com.lucas.exams.model.Alternativa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlternativaRepository extends CrudRepository<Alternativa, Long> {

    List<Alternativa> findAllByQuestaoId(Long id);

    List<Alternativa> findAllByGabaritoId(Long id);

    Alternativa findFirstById(Long id);

    @Query(value = "SELECT ALTERNATIVA.ID FROM PROVA " +
            "INNER JOIN QUESTAO ON PROVA.ID = QUESTAO.PROVAID " +
            "INNER JOIN ALTERNATIVA ON QUESTAO.ID = ALTERNATIVA.QUESTAOID " +
            "WHERE PROVA.SIMULADOID = 1 " +
            "AND ALTERNATIVA.GABARITOID IS NOT NULL", nativeQuery = true)
    List<Alternativa> findAllBySimuladoId();

}
