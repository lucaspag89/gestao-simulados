package com.lucas.exams.controller.aluno;

import com.lucas.exams.dto.aluno.AlunoDTO;
import com.lucas.exams.model.Aluno;
import com.lucas.exams.service.aluno.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping()
    public ResponseEntity<List<Aluno>> findAllAlunos() {

        try {
            List<Aluno> alunos = alunoService.findAllAlunos();

            if (alunos.size() > 0) {
                return new ResponseEntity<>(alunos, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findByAlunoId(@PathVariable("id") Long id) {

        try {
            Aluno aluno = alunoService.findByAlunoId(id);

            if (aluno != null) {
                return new ResponseEntity<>(aluno, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Aluno> registerAluno(@RequestBody AlunoDTO alunoDTO) {

        Aluno aluno = null;
        try {

            if (alunoDTO != null) {
                aluno = alunoService.registerAluno(alunoDTO);

                return new ResponseEntity<>(aluno, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(aluno, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {

        Aluno aluno = null;

        try {
            if (alunoDTO != null) {
                aluno = alunoService.updateAluno(id, alunoDTO);

                if (aluno == null) {
                    return new ResponseEntity<>(aluno, HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(aluno, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(aluno, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Aluno> removeAluno(@PathVariable("id") Long id) {
        try {

            Aluno aluno = alunoService.removeAluno(id);

            if (aluno != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

