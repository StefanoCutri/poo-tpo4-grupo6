package org.uade.controllers;

import org.uade.models.CondicionesDescuento;
import org.uade.models.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class DescuentoController {
    private List<CondicionesDescuento> descuentos;
    private static DescuentoController INSTANCE = null;

    private DescuentoController() {
        this.descuentos = new ArrayList<>();

    }

    // Singleton
    public static synchronized DescuentoController getInstances(){
        if(INSTANCE == null){
            INSTANCE = new DescuentoController();
        }
        return INSTANCE;
    }

    // metodos

    public void AMB(){}
}
