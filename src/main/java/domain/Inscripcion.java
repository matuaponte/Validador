package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Inscripcion {

    private Alumno alumno;
    private Set<Materia> materiasAcursar;

    public Inscripcion(Alumno alumno) {
        this.materiasAcursar = new HashSet<>();
        this.alumno = alumno;
    }

    public boolean aprobada(){
        return this.materiasAcursar.stream().allMatch(m -> m.cumpleCorrelativas(alumno.getMateriasAprobadas()));
    }
    public void agregarMateriaAcursar(Materia materia){
        materiasAcursar.add(materia);
    }
}
