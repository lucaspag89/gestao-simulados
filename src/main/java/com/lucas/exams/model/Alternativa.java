package com.lucas.exams.model;

import com.lucas.exams.model.questao.Questao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alternativa")
public class Alternativa implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "opcao")
    private String opcao;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "gabaritoid")
    private Gabarito gabarito;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "questaoid")
    private Questao questao;

}
