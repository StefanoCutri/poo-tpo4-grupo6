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

    private float precioEntrada = 3600;


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
        float descuento = 0f;

        if (pelicula != null && pelicula.getCondicionesDescuento() != null) {
            descuento = pelicula.getCondicionesDescuento().getDescuento();
        }

        if (entradas != null) {
            for (Entrada entrada : entradas) {
                total += entrada.getPrecio() - (entrada.getPrecio() * descuento);
            }
        }

        return total;
    }

    public float getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(float precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

}