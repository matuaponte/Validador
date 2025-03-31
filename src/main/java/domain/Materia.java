package domain;

import lombok.Getter;

import java.util.Set;

public class Materia {
    private String nombre;
    @Getter
    private Set<Materia> correlativas;

    public Materia(String nombre, Set<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public boolean cumpleCorrelativas(Set<Materia> materias) {
        return materias.containsAll(correlativas);
    }



}


