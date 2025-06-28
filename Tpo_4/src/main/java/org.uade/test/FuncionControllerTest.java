package org.uade.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uade.controllers.FuncionController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.models.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.uade.controllers.FuncionController;
import org.uade.controllers.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.models.Funcion;
import org.uade.models.Pelicula;
import org.uade.models.Sala;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FuncionControllerTest {

    private FuncionController funcionController;
    private PeliculasController peliculasController;

    private Pelicula peliculaDrama;
    private Pelicula peliculaTerror;

    private Funcion funcionDrama;
    private Funcion funcionTerror;

    @BeforeAll
    public void setup() {
        funcionController = FuncionController.getInstance();
        peliculasController = PeliculasController.getInstancia();

        peliculaDrama = new Pelicula(
                TipoGenero.Drama,
                "Director Drama",
                100,
                "Drama Movie",
                TipoProyeccion.DosD,
                new ArrayList<>(),
                null
        );

        peliculaTerror = new Pelicula(
                TipoGenero.Terror,
                "Director Terror",
                90,
                "Terror Movie",
                TipoProyeccion.TresD,
                new ArrayList<>(),
                null
        );

        peliculasController.registrarPelicula(peliculaDrama);
        peliculasController.registrarPelicula(peliculaTerror);

        funcionDrama = new Funcion(
                new Date(),
                funcionController.obtenerProximoID(),
                "14:00",
                new ArrayList<>(),
                new Sala(1, "Sucursal 1", 100),
                peliculaDrama
        );

        funcionTerror = new Funcion(
                new Date(),
                funcionController.obtenerProximoID(),
                "16:00",
                new ArrayList<>(),
                new Sala(2, "Sucursal 2", 80),
                peliculaTerror
        );

        funcionController.agregarFuncion(funcionDrama);
        funcionController.agregarFuncion(funcionTerror);
    }

    @Test
    @DisplayName("Registrar función y buscar funciones por género")
    public void testRegistrarFuncionYBuscarPorGenero() {
        List<Funcion> funcionesDrama = funcionController.buscarPeliculaPorGenerosFuncion(TipoGenero.Drama);
        List<Funcion> funcionesTerror = funcionController.buscarPeliculaPorGenerosFuncion(TipoGenero.Terror);

        assertTrue(funcionesDrama.contains(funcionDrama), "Debe contener la función con película Drama");
        assertTrue(funcionesTerror.contains(funcionTerror), "Debe contener la función con película Terror");
    }
}