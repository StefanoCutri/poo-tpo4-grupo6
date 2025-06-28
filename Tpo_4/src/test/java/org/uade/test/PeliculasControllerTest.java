package org.uade.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.uade.controllers.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.models.Pelicula;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PeliculasControllerTest {

    private PeliculasController peliculasController;
    private Pelicula peliculaDrama;
    private Pelicula peliculaTerror;

    @BeforeAll
    public void setUp() {
        peliculasController = PeliculasController.getInstancia();

        peliculaDrama = new Pelicula(
                TipoGenero.Drama,
                "Director Drama",
                100,
                "Drama Movie",
                TipoProyeccion.DosD,
                Arrays.asList("Actor A", "Actor B"),
                null
        );

        peliculaTerror = new Pelicula(
                TipoGenero.Terror,
                "Director Terror",
                90,
                "Terror Movie",
                TipoProyeccion.TresD,
                Arrays.asList("Actor X", "Actor Y"),
                null
        );

        peliculasController.registrarPelicula(peliculaDrama);
        peliculasController.registrarPelicula(peliculaTerror);
    }

    @Test
    @DisplayName("Registrar y buscar película por género")
    public void testRegistrarYBuscarPeliculasPorGenero() {
        List<Pelicula> peliculasDrama = peliculasController.buscarPeliculasPorGenero(TipoGenero.Drama);
        List<Pelicula> peliculasTerror = peliculasController.buscarPeliculasPorGenero(TipoGenero.Terror);

        assertTrue(peliculasDrama.contains(peliculaDrama), "Debe contener la película Drama");
        assertTrue(peliculasTerror.contains(peliculaTerror), "Debe contener la película Terror");
    }
}