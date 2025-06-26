package org.uade.models;

import org.uade.enums.TipoTarjeta;

import java.util.Date;
import java.util.List;

public class CondicionesDescuento {
    private Date fchDesde;
    private Date fchHasta;
    private int diaSemana;
    private float porcentaje;
    private TipoTarjeta tipoTarjeta;

    private List<TarjetaDescuento> tarjetasDescuento;


    public float getPorcentaje() {
        return porcentaje;
    }

    public Date getFchDesde() {
        return fchDesde;
    }

    public Date getFchHasta() {
        return fchHasta;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public List<TarjetaDescuento> getTarjetasDescuento() {
        return tarjetasDescuento;
    }


    // Metodos

    public float getDescuento(){
        return 0;
    }

    public float getDescuentoPorTarjeta(TipoTarjeta tipoTarjeta){
        return 0;
    }

}
