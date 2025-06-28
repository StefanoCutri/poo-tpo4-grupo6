package org.uade.models;

import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;

import java.util.*;

public class Pelicula {

    public Pelicula(TipoGenero genero, String director, int duracionEnMinutos, String nombrePelicula, TipoProyeccion tipo, List<String> actores, CondicionesDescuento descuento) {
    
    this.actores = actores;
    this.director = director;
    this.duracionEnMinutos = duracionEnMinutos;
    this.genero = genero;
    this.nombrePelicula = nombrePelicula;
    this.tipo = tipo;
    this.condicionesDescuento = descuento;

    }

    private TipoGenero genero;

    private String nombrePelicula;

    private int duracionEnMinutos;

    private String director;

    private List<String> actores;

    private TipoProyeccion tipo;

    private CondicionesDescuento condicionesDescuento;

    public int getPeliculaID() {
        return this.getPeliculaID();
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public void setGeneroID(TipoGenero generoID) {
        this.genero = genero;
    }

    public CondicionesDescuento getCondicionesDescuento() {
        return condicionesDescuento;
    }

}