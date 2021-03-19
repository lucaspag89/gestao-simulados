package com.lucas.exams.model;

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
@Table(name = "gabarito")
public class Gabarito implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @OneToMany(mappedBy = "gabarito", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alternativa> alternativas;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "provaid")
    private Prova prova;

}
