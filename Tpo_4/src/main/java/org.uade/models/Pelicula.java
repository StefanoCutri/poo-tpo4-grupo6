package org.uade.models;

import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;

import java.util.*;

public class Pelicula {

    public Pelicula(TipoGenero generoID, String director, int duracionEnMinutos, String nombrePelicula, TipoProyeccion tipo, List<String> actores, CondicionesDescuento descuento) {
    
    this.actores = actores;
    this.director = director;
    this.duracionEnMinutos = duracionEnMinutos;
    this.genero = generoID;
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

    @Override
    public String toString() {
        return this.getNombrePelicula(); // o lo que quieras mostrar en el combo
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }
}