package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


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

        Assertions.assertTrue(inscripcionMati.aprobada());
    }

    @Test
    public void inscripcionFallidaDds() {

        inscripcionFranco = new Inscripcion(franco);
        inscripcionFranco.agregarMateriaAcursar(dds);

        Assertions.assertFalse(inscripcionFranco.aprobada());
    }

    @Test
    public void inscripcionAprobadaVariasMaterias() {

        inscripcionMati = new Inscripcion(matias);
        inscripcionMati.agregarMateriaAcursar(dds);
        inscripcionMati.agregarMateriaAcursar(inglesII);

        Assertions.assertTrue(inscripcionMati.aprobada());
    }

    @Test
    public void inscripcionFallidaCuandoUnaNoCumple() {

        inscripcionFranco = new Inscripcion(franco);
        inscripcionFranco.agregarMateriaAcursar(inglesII);
        inscripcionFranco.agregarMateriaAcursar(pdp);

        Assertions.assertFalse(inscripcionFranco.aprobada());
    }
}