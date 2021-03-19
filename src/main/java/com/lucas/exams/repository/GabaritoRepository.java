package com.lucas.exams.repository;

import com.lucas.exams.model.Alternativa;
import com.lucas.exams.model.Gabarito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GabaritoRepository extends CrudRepository<Gabarito, Long> {

    Gabarito findFirstByProvaId(Long id);

}
