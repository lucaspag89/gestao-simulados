package com.lucas.exams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lucas.exams.dto.aluno.AlunoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "matricula")
    private Long matricula;

    @Getter
    @Setter
    @Column(name = "nome")
    private String nome;

    @Getter
    @Setter
    @Column(name = "sobrenome")
    private String sobrenome;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "escola")
    private String escola;

    public Aluno(Long id) {
        this.id = id;
    }

    public Aluno fromAlunoDTO(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();

        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setNome(alunoDTO.getNome());
        aluno.setSobrenome(alunoDTO.getSobrenome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setEscola(alunoDTO.getEscola());

        return aluno;
    }

    public Aluno fromAlunoDTO(AlunoDTO alunoDTO, Long alunoid) {
        Aluno aluno = new Aluno();

        aluno.setId(alunoid);
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setNome(alunoDTO.getNome());
        aluno.setSobrenome(alunoDTO.getSobrenome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setEscola(alunoDTO.getEscola());

        return aluno;
    }
}
