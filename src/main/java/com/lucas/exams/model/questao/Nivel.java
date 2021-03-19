package com.lucas.exams.model.questao;

public enum Nivel {

    FACIL,
    MEDIO,
    DIFICIL;

    public static Nivel fromName(String name){
        for (Nivel nivel : Nivel.values()){
            if (nivel.name().equalsIgnoreCase(name)){
                return nivel;
            }
        }

        return null;
    }

}
