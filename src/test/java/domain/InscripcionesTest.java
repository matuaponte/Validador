package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class InscripcionesTest{
    private Alumno matias;
    private Alumno franco;
    private Materia dds;
    private Materia ads;
    private Materia pdp;
    private Materia ayed;
    private Materia sypn;
    private Materia ingles;
    private Materia discreta;
    private Materia inglesII;
    private Inscripcion inscripcionMati;
    private Inscripcion inscripcionFranco;


    @BeforeEach
    public void setUp() {
        ads = new Materia("Análisis de Sistemas");
        pdp = new Materia("Paradigmas de Programación");
        ayed = new Materia("Algoritmos y Estructuras de Datos");
        sypn = new Materia("Sistemas y Procesos De Negocios");
        ingles = new Materia("Inglés");
        discreta = new Materia("Matematica Discreta");
        dds = new Materia("Diseño de Sistemas");
        inglesII = new Materia("Ingles 2");

        dds.agregarCorrelativa(ads);
        dds.agregarCorrelativa(pdp);
        dds.agregarCorrelativa(ingles);

        pdp.agregarCorrelativa(ayed);
        pdp.agregarCorrelativa(discreta);

        ads.agregarCorrelativa(sypn);
        ads.agregarCorrelativa(ayed);

        inglesII.agregarCorrelativa(ingles);


        matias = new Alumno("Matias", "Aponte");
        matias.agregarMateriaAprobada(ads);
        matias.agregarMateriaAprobada(pdp);
        matias.agregarMateriaAprobada(ingles);
        matias.agregarMateriaAprobada(discreta);
        matias.agregarMateriaAprobada(sypn);
        matias.agregarMateriaAprobada(ayed);

        franco = new Alumno("Franco", "Andino");
        franco.agregarMateriaAprobada(ads);
        franco.agregarMateriaAprobada(sypn);
        franco.agregarMateriaAprobada(ayed);
        franco.agregarMateriaAprobada(ingles);

    }
    @Test
    public void inscripcionAprobadaDds(){

        inscripcionMati = new Inscripcion(matias);
        inscripcionMati.agregarMateriaAcursar(dds);

        assertTrue(inscripcionMati.aprobada(), "La inscripción debería ser aprobada.");
    }

    @Test
    public void inscripcionFallidaDds() {

        inscripcionFranco = new Inscripcion(franco);
        inscripcionFranco.agregarMateriaAcursar(dds);

        assertFalse(inscripcionFranco.aprobada(), "La inscripción no debería ser aprobada.");
    }

    @Test
    public void inscripcionAprobadaVariasMaterias() {

        inscripcionMati = new Inscripcion(matias);
        inscripcionMati.agregarMateriaAcursar(dds);
        inscripcionMati.agregarMateriaAcursar(inglesII);

        assertTrue(inscripcionMati.aprobada(), "La inscripción con varias materias tiene que ser aprobada.");
    }

    @Test
    public void inscripcionFallidaCuandoUnaNoCumple() {

        inscripcionFranco = new Inscripcion(franco);
        inscripcionFranco.agregarMateriaAcursar(inglesII);
        inscripcionFranco.agregarMateriaAcursar(pdp);

        assertFalse(inscripcionFranco.aprobada(), "La inscripción no debería ser aprobada si al menos una materia no cumple.");
    }
}