package com.lucas.exams.model;

import com.lucas.exams.model.questao.Questao;
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
@Table(name = "prova")
public class Prova implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "simuladoid")
    private Simulado simulado;

    @Getter
    @Setter
    @OneToOne(mappedBy = "prova", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Gabarito gabarito;

    @Getter
    @Setter
    @OneToMany(mappedBy = "prova", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Questao> questoes;

}
