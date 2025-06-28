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

    private int peliculaID;

    private TipoGenero genero;

    private String nombrePelicula;

    private int duracionEnMinutos;

    private String director;

    private List<String> actores;

    private TipoProyeccion tipo;

    private CondicionesDescuento condicionesDescuento;

    public int getPeliculaID() {
        return this.peliculaID;
    }

    public void setPeliculaID(int peliculaID) {
        this.peliculaID = peliculaID;
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public void setGeneroID(TipoGenero generoID) {

        this.genero = generoID;
    }

    public CondicionesDescuento getCondicionesDescuento() {
        return condicionesDescuento;
    }

    @Override
    public String toString() {
        return "ID: " + getPeliculaID() + " | Título: " + getNombrePelicula() + " | Duración: " + getDuracionEnMinutos() + " min";
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setCondicionesDescuento(CondicionesDescuento condicionesDescuento) {
        this.condicionesDescuento = condicionesDescuento;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pelicula pelicula = (Pelicula) obj;
        return Objects.equals(nombrePelicula, pelicula.nombrePelicula); // o compará por ID si lo tenés
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrePelicula);
    }
}