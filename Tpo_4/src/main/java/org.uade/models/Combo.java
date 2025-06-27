package org.uade.models;

public class Combo {

    /**
     * Default constructor
     */
    public Combo(int comboID, String descripcion, float precio, CondicionesDescuento Contiene) {
        this.comboID = comboID;
        this.Contiene = Contiene;
        this.descripcion = descripcion;
        this.precio = precio;
    }


    private int comboID;

    private String descripcion;

    private float precio;

    public CondicionesDescuento Contiene;

    public float getPrecio() {
        return this.precio;
    }

    public int getComboID() {
		return comboID;
    }
}