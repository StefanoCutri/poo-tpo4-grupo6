package org.uade.models;

public class Combo {
    private int comboID;
    private String description;
    private float precio;
    public CondicionesDescuento ContieneCondicionDescuento;

    // metodos
    public float getPrecio() {
        return precio;
    }

    public int getComboID() {
        return comboID;
    }
}
