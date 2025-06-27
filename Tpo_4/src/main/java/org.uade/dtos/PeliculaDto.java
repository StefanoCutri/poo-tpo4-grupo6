package org.uade.dtos;

import org.uade.enums.TipoGenero;

public class PeliculaDto {
    public String nombre;
    public TipoGenero genero;
    public int duracion;
    public String director;
    public String actores;

    public PeliculaDto(String nombre, TipoGenero genero, int duracion, String director, String actores) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.director = director;
        this.actores = actores;
    }
}
