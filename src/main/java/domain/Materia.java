package domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    @Getter
    private Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public boolean cumpleCorrelativas(Set<Materia> materias) {
        return materias.containsAll(correlativas);
    }

    public void agregarCorrelativa(Materia materia){
        correlativas.add(materia);
    }

}


