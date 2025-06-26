package org.uade.controllers;

import org.uade.models.Sala;
import org.uade.models.Sucursal;
import org.uade.models.Venta;

import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    private List<Sucursal> sucursales;
    private static SucursalController INSTANCE = null;

    private SucursalController() {
        this.sucursales = new ArrayList<>();

    }

    // Singleton
    public static synchronized SucursalController getInstances(){
        if(INSTANCE == null){
            INSTANCE = new SucursalController();
        }
        return INSTANCE;
    }


    // metodos

    public void agregarSucursal(Sucursal sucursal){
        this.sucursales.add(sucursal);
    }

    public void agregarSala(Sala sala){

    }
}
