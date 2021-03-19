package com.lucas.exams.repository;

import com.lucas.exams.model.Alternativa;
import com.lucas.exams.model.Simulado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimuladoRepository extends CrudRepository<Simulado, Long> {

    List<Simulado> findAll();

    Simulado findFirstById(Long id);

    @Query(value = "SELECT ALTERNATIVA.ID FROM PROVA " +
            "INNER JOIN QUESTAO ON PROVA.ID = QUESTAO.PROVAID " +
            "INNER JOIN ALTERNATIVA ON QUESTAO.ID = ALTERNATIVA.QUESTAOID " +
            "WHERE PROVA.SIMULADOID = :id " +
            "AND ALTERNATIVA.GABARITOID IS NOT NULL", nativeQuery = true)
    List<Simulado> findAllBySimuladoId(@Param("id") Long id);

}
