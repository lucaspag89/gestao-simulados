package com.lucas.exams.service.aluno;

import com.lucas.exams.dto.aluno.AlunoDTO;
import com.lucas.exams.model.Aluno;
import com.lucas.exams.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> findAllAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno findByAlunoId(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        return aluno.orElse(null);

    }

    @Override
    public Aluno registerAluno(AlunoDTO alunoDTO) {

        if (alunoDTO != null) {
            Aluno aluno = new Aluno();
            aluno = aluno.fromAlunoDTO(alunoDTO);

            alunoRepository.save(aluno);

            return aluno;
        }

        return null;
    }

    @Override
    public Aluno updateAluno(Long id, AlunoDTO alunoDTO) {
        Optional<Aluno> currentAluno = alunoRepository.findById(id);

        if (currentAluno.isEmpty()) {
            return null;
        }
        Long alunoid = currentAluno.get().getId();

        Aluno aluno = new Aluno().fromAlunoDTO(alunoDTO, alunoid);

        alunoRepository.save(aluno);

        return aluno;
    }

    @Override
    public Aluno removeAluno(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isPresent()) {
            alunoRepository.delete(aluno.get());

            return aluno.get();
        }

        return null;
    }
}
