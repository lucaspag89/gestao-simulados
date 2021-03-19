package com.lucas.exams.service.aluno;

import com.lucas.exams.dto.aluno.AlunoDTO;
import com.lucas.exams.model.Aluno;

import java.util.List;

public interface AlunoService {

    List<Aluno> findAllAlunos();

    Aluno findByAlunoId(Long id);

    Aluno registerAluno(AlunoDTO alunoDTO);

    Aluno updateAluno(Long id, AlunoDTO alunoDTO);

    Aluno removeAluno(Long id);

}
