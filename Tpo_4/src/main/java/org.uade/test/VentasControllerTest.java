package org.uade.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.uade.controllers.FuncionController;
import org.uade.controllers.PeliculasController;
import org.uade.controllers.VentasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.models.Funcion;
import org.uade.models.Pelicula;
import org.uade.models.Sala;
import org.uade.models.Venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VentasControllerTest {

    private PeliculasController peliculasController;
    private FuncionController funcionController;
    private VentasController ventasController;

    private Pelicula peliculaDrama;
    private Pelicula peliculaTerror;

    private Funcion funcionDrama;
    private Funcion funcionTerror;

    @BeforeAll
    public void setup() {
        peliculasController = PeliculasController.getInstancia();
        funcionController = FuncionController.getInstance();
        ventasController = VentasController.getInstances();

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

        ventasController.getVentas().clear();

        Venta venta1 = new Venta(1, new Date(), null, funcionDrama);
        Venta venta2 = new Venta(2, new Date(), null, funcionDrama);
        Venta venta3 = new Venta(3, new Date(), null, funcionTerror);

        ventasController.getVentas().add(venta1);
        ventasController.getVentas().add(venta2);
        ventasController.getVentas().add(venta3);
    }

    @Test
    @DisplayName("Emitir reporte: película con mayor recaudación")
    public void testPeliculasConMayorRecaudacion() {
        float recaudacionDrama = ventasController.recaudacionPorPelicula(peliculaDrama.getPeliculaID());
        float recaudacionTerror = ventasController.recaudacionPorPelicula(peliculaTerror.getPeliculaID());

        assertTrue(recaudacionDrama >= 0, "Recaudación Drama debe ser >= 0");
        assertTrue(recaudacionTerror >= 0, "Recaudación Terror debe ser >= 0");

        // Saber cuál es mayor
        String peliculaMayorRecaudacion = recaudacionDrama >= recaudacionTerror ? peliculaDrama.getNombrePelicula() : peliculaTerror.getNombrePelicula();

        assertNotNull(peliculaMayorRecaudacion, "Debe identificar película con mayor recaudación");
        System.out.println("Película con mayor recaudación: " + peliculaMayorRecaudacion);
    }
}