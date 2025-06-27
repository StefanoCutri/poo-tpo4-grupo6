package org.uade.models;

import java.util.*;

public class Sala {

    public Sala(int salaID, String denominacion, int asientos) {
        this.asientos = asientos;
        this.denominacion = denominacion;
        this.salaID = salaID;
    }

    private int salaID;

    private String denominacion;

    private int asientos;

    public int getSucursalID() {
        return 0;
    }

    public int getSalaID() {
        return this.salaID;
    }

    public int getAsientos() {
        return this.asientos;
    }

}