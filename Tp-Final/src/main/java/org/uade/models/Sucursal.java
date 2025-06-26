package org.uade.models;

import java.util.List;

public class Sucursal {
    private int sucursalID;
    private String denominacion;
    private String direccion;
    private List<Sala> salas;

    public int getSucursalID() {
        return sucursalID;
    }
}
