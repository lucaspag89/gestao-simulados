package com.lucas.exams.repository;

import com.lucas.exams.model.questao.Questao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoRepository extends CrudRepository<Questao, Long> {

    List<Questao> findAllByProvaId(Long id);

    Questao findFirstById(Long id);

}
