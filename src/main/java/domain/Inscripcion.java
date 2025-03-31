package domain;

import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasAcursar;
//    private boolean fueAprobada;

    public Inscripcion(Set<Materia> materiasAcursar, Alumno alumno) {
        this.materiasAcursar = materiasAcursar;
        this.alumno = alumno;
    }

    public boolean aprobada(){
        return this.materiasAcursar.stream().allMatch(m -> m.cumpleCorrelativas(alumno.getMateriasAprobadas()));
    }
}
