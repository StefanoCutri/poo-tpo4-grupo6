package org.uade.models;

import java.util.*;

/**
 * 
 */
public class Funcion {

    /**
     * Default constructor
     */
    public Funcion(Date fecha, int funcionID, String horario, List<Entrada> entradas, Sala sala, Pelicula pelicula) {
    	
    	this.entradas = entradas;
    	this.fecha = fecha;
    	this.funcionID = funcionID;
    	this.horario = horario;    	
    	this.sala = sala;
    	this.pelicula = pelicula;
    	
    }

    private List<Entrada> entradas;
    private Sala sala;
    private Pelicula pelicula;
    private String horario;
    private Date fecha;
    private int funcionID;


    public Pelicula getPelicula() {
        return pelicula;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public int getSalaID() {
        return this.sala.getSalaID();
    }

    public int getSucursalID() {
        return this.sala.getSucursalID();
    }

    public int getPeliculaID() {
            return pelicula.getPeliculaID();
    }

    public int getCantidadAsientosDisponibles() {
		return this.sala.getAsientos();
    }


    public int getFuncionID() {

        return this.funcionID;
    }

    public Date getFecha() {
		return this.fecha;
    }

    public float calcularMontoPorEntradaDeLaPelicula(){
        float total = 0.0f;
        for (Entrada entrada:getEntradas()) {
            total = total+ (entrada.getPrecio() -
                    (entrada.getPrecio()*this.pelicula.getCondicionesDescuento().getDescuento()));
        }
        return total;
    }

}