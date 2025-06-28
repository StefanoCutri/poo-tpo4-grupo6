package org.uade.controllers;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.models.Pelicula;

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