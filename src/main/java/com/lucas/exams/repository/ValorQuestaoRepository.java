package com.lucas.exams.repository;

import com.lucas.exams.model.ValorQuestao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorQuestaoRepository extends CrudRepository<ValorQuestao, Long> {

    ValorQuestao getFirstById(Long id);
}
