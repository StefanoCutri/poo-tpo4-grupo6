package org.uade.models;

import java.util.*;

/**
 * 
 */
public class Sala {

    /**
     * Default constructor
     */
    public Sala(int salaID, String denominacion, int asientos) {
    	this.asientos = asientos;
    	this.denominacion = denominacion;
    	this.salaID = salaID;
    }

    /**
     * 
     */
    private int salaID;

    /**
     * 
     */
    private String denominacion;

    /**
     * 
     */
    private int asientos;



    /**
     * @return
     */
    public int getSucursalID() {
        return 0;
    }

    /**
     * @return
     */
    public int getSalaID() {
        return this.salaID;
    }

    /**
     * @return
     */
    public int getAsientos() {
        return this.asientos;
    }

}