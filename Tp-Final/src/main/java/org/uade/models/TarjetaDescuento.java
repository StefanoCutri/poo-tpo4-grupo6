package org.uade.models;

import org.uade.enums.TipoTarjeta;

public class TarjetaDescuento {

    private int tarjetaID;
    private TipoTarjeta tipoTarjeta;
    private String numeroTarjeta;

    public int getTarjetaID() {
        return tarjetaID;
    }

    public void setTarjetaID(int tarjetaID) {
        this.tarjetaID = tarjetaID;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }


    // Metodos
    public TipoTarjeta getTipoTarjeta(){
        return null;
    }
}
