package org.uade.dtos;

import org.uade.models.Entrada;
import org.uade.models.Pelicula;
import org.uade.models.Sala;

import java.util.Date;
import java.util.List;

public class FuncionDto {
    private Pelicula pelicula;
    private int funcionID;
    private String horario;
    private Date fecha;
    private List<Entrada> entradas;
    private Sala sala;

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public int getFuncionID() {
        return funcionID;
    }

    public void setFuncionID(int funcionID) {
        this.funcionID = funcionID;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
