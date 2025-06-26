package org.uade.models;

import org.uade.enums.TipoTarjeta;

import java.util.Date;
import java.util.List;

public class Venta {
    private int ventaID;
    private Date fchVenta;
    private List<Combo> combos;
    private Funcion funcion;
    private TarjetaDescuento tarjetaDescuento; //


    public List<Combo> getCombos() {
        return combos;
    }

    public TarjetaDescuento getTarjetaDescuento() {
        return tarjetaDescuento;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;

    }

    // metodos

    public int getFuncionID(){
        return funcion.getFuncionID();
    }

    public float getTotal(){
        return 0;
    }

    public int getPeliculaID(){
        return 0;
    }

    public TipoTarjeta getTipoTarjeta(){
        return null;
    }

    public float calcularMontoPorComboDeVenta(){
        return 0;
    }

    public float calcularMontoDeLaVentaPorFuncionCombos(){
        return 0;
    }
}
