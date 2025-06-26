package org.uade.controllers;

import org.uade.models.Pelicula;
import org.uade.models.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class PeliculasController {
    private List<Pelicula> peliculas;
    private static PeliculasController INSTANCE = null;

    private PeliculasController() {
        this.peliculas = new ArrayList<>();

    }

    // Singleton
    public static synchronized PeliculasController getInstances(){
        if(INSTANCE == null){
            INSTANCE = new PeliculasController();
        }
        return INSTANCE;
    }

    // metodos

    public void AMB(){}
}
