package com.lucas.exams.model.questao;

import com.lucas.exams.model.Alternativa;
import com.lucas.exams.model.Prova;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questao")
public class Questao implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    private String enunciado;

    @Getter
    @Setter
    @Column(name = "nivel")
    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "provaid")
    private Prova prova;

    @Getter
    @Setter
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alternativa> alternativas;

}
