package org.uade.test;

import org.junit.jupiter.api.*;
import org.uade.controllers.FuncionController;
import org.uade.controllers.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.models.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FuncionControllerTest {

    private FuncionController funcionController;
    private PeliculasController peliculasController;
    private Pelicula peliculaTerror;
    private Sala sala;
    private Funcion funcionTerror;

    @BeforeAll
    public void setup() {
        funcionController = FuncionController.getInstance();
        peliculasController = PeliculasController.getInstance();

        // Crear y registrar película de terror
        peliculaTerror = new Pelicula(
                TipoGenero.Terror,
                "Director Terror",
                90,
                "Terror Movie",
                TipoProyeccion.DosD,
                Arrays.asList("Actor X", "Actor Y"),
                null
        );
        peliculasController.registrarPelicula(peliculaTerror);

        // Crear sala
        sala = new Sala(100, "Sala 1", 1);

        // Crear y agregar función con ID único y fecha diferente
        funcionTerror = new Funcion(
                new Date(System.currentTimeMillis() + 86400000), // mañana
                funcionController.obtenerProximoID(),
                "22:00",
                new ArrayList<>(),
                sala,
                peliculaTerror
        );
        boolean agregado = funcionController.agregarFuncion(funcionTerror);
        assertTrue(agregado, "La función debería haberse agregado correctamente");
    }

    @Test
    @DisplayName("Buscar funciones por género Terror")
    public void testRegistrarFuncionYBuscarPorGenero() {
        List<Funcion> funcionesTerror = funcionController.buscarPeliculaPorGenerosFuncion(TipoGenero.Terror);

        // Verificamos por ID, no por contains()
        boolean encontrada = funcionesTerror.stream()
                .anyMatch(f -> f.getFuncionID() == funcionTerror.getFuncionID());

        assertTrue(encontrada, "Debe contener la función con película Terror");
    }
}
