package com.lucas.exams.repository;

import com.lucas.exams.model.Prova;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvaRepository extends CrudRepository<Prova, Long> {

    List<Prova> findAllBySimuladoId(Long id);

    Prova findFirstById(Long id);

}
