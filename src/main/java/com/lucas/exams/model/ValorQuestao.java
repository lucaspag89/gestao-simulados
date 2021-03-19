package com.lucas.exams.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "valorquestao")
public class ValorQuestao implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "facil")
    private Long facil;

    @Getter
    @Setter
    @Column(name = "medio")
    private Long medio;

    @Getter
    @Setter
    @Column(name = "dificil")
    private Long dificil;

    @Getter
    @Setter
    @Column(name = "fator")
    private Long fator;

}

