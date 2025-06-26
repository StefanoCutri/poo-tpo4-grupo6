package org.uade.models;

import java.util.Date;
import java.util.List;

public class Funcion {
    private Pelicula pelicula;
    private int funcionID;
    private String horario;
    private Date fecha;
    private List<Entrada> entradas;
    private Sala sala;


    public Pelicula getPelicula() {
        return pelicula;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getSalaID() {
        return 0;
    }

    public int getSucursalID(){
        return 0;
    }

    public int peliculaID(){
        return 0;
    }

    public int getCantidadAsientosDisponibles(){
        return 0;
    }

    public int getFuncionID(){
        return funcionID;
    }

    public float calcularMontoPorEntradaDeLaPelicula(){
        return 0;
    }
}
