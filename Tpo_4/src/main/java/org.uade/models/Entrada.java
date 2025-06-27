package org.uade.models;

import java.util.*;

public class Entrada {

    public Entrada(int nroAsiento, Funcion funcion, float precio) {
    	this.funcion = funcion;
    	this.nroAsiento = nroAsiento;
    	this.precio = precio;
    }
    
    public Entrada() {

    }

    public float getPrecio() {
        return precio;
    }

    private float precio;

    private int nroAsiento;

    public Funcion funcion;


    public int getFuncionID() {
        return funcion.getFuncionID();
    }

    public void getPeliculaID() {
        // TODO implement here
    }

}