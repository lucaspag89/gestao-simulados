package com.lucas.exams.dto.aluno;

import com.lucas.exams.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO implements Serializable {

    @Getter
    @Setter
    private Long matricula;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String sobrenome;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String escola;

}
