package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
public class Alumno {
    @Setter
    private String nombre;
    @Setter
    private String apellido;
    private Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, Set<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = materiasAprobadas;
    }

    public void agregarMateriaAprobada(Materia materia){
        materiasAprobadas.add(materia);
    }

}
