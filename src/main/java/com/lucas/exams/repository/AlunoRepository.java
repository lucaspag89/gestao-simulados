package com.lucas.exams.repository;

import com.lucas.exams.model.Aluno;
import com.lucas.exams.model.RespostaAluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

    List<Aluno> findAll();

    Aluno findFirstById(Long id);


}
