package org.uade.dtos;

import org.uade.models.Combo;
import org.uade.models.Funcion;
import org.uade.models.TarjetaDescuento;

import java.util.Date;
import java.util.List;

public class VentaDto {
    private int ventaID;
    private Date fchVenta;
    private List<Combo> combos;
    private Funcion funcion;
    private TarjetaDescuento tarjetaDescuento;

    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public Date getFchVenta() {
        return fchVenta;
    }

    public void setFchVenta(Date fchVenta) {
        this.fchVenta = fchVenta;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public TarjetaDescuento getTarjetaDescuento() {
        return tarjetaDescuento;
    }

    public void setTarjetaDescuento(TarjetaDescuento tarjetaDescuento) {
        this.tarjetaDescuento = tarjetaDescuento;
    }
}
