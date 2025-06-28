package org.uade.controllers;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.enums.TipoTarjeta;
import org.uade.models.CondicionesDescuento;
import org.uade.models.Pelicula;
import org.uade.models.TarjetaDescuento;


import java.util.Calendar;
import java.util.Date;
import java.util.*;


/**
 * 
 */
    	
public class PeliculasController {

    private static PeliculasController instancia = null;

    private List<Pelicula> peliculas;
    private int contadorID = 1;


    private PeliculasController() {
        peliculas = new ArrayList<>();

        Calendar calDesde = Calendar.getInstance();
        calDesde.set(2024, Calendar.JANUARY, 1);
        Date fchDesde = calDesde.getTime();

        Calendar calHasta = Calendar.getInstance();
        calHasta.set(2025, Calendar.DECEMBER, 31);
        Date fchHasta = calHasta.getTime();

        // Otros parámetros
        int diaSemana = Calendar.MONDAY;
        float porcentaje = 0.2f;
        TipoTarjeta tipoTarjeta = TipoTarjeta.UADE;

        ArrayList<TarjetaDescuento> tarjetas = new ArrayList<>();
        int tarjetaID = 1;
        String numeroTarjeta = "1234-5678-9012-3456"; // ejemplo

        tarjetas.add(new TarjetaDescuento(tarjetaID, tipoTarjeta, numeroTarjeta));

        // Película de prueba
        Pelicula pelicula = new Pelicula(
                TipoGenero.Terror,
                "Steven Spielberg",
                120,
                "Tiburón",
                TipoProyeccion.DosD,
                new ArrayList<>(), // actores
                null               // sin imagen
        );
        pelicula.setPeliculaID(1);
        CondicionesDescuento condiciones = new CondicionesDescuento(
                fchDesde,
                fchHasta,
                diaSemana,
                porcentaje,
                tipoTarjeta,
                tarjetas
        );
        pelicula.setCondicionesDescuento(condiciones);
        peliculas.add(pelicula);
    }

    public static PeliculasController getInstancia() {
        if (instancia == null) {
            instancia = new PeliculasController();
        }
        return instancia;
    }

    public static PeliculasController getInstance() {
        if (instancia == null) {
            instancia = new PeliculasController();
        }
        return instancia;
    }

    public void registrarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public List<Pelicula> buscarPeliculasPorGenero(TipoGenero genero) {
        List<Pelicula> resultado = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getGenero().equals(genero)) {
                resultado.add(pelicula);
            }
        }
        return resultado;
    }

    public List<Pelicula> getTodasLasPeliculas() {
        return peliculas;
    }

    public int generarNuevoID() {
        return contadorID++;
    }

}