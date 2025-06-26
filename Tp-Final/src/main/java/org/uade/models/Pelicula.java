package org.uade.models;

import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;

import java.util.List;

public class Pelicula {
    private TipoGenero generoID;
    private String nombrePelicula;
    private int duracionEnMinutos;
    private String director;
    private List<String> actores;
    private TipoProyeccion tipoProyeccion;
    private CondicionesDescuento condicionesDescuento;

    public TipoGenero getGeneroID() {
        return generoID;
    }

    public void setGeneroID(TipoGenero generoID) {
        this.generoID = generoID;
    }

    public CondicionesDescuento getCondicionesDescuento() {
        return condicionesDescuento;
    }

    public int getPeliculaID(){
        return 0;
    }
}
