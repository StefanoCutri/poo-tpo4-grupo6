package org.uade.models;
import org.uade.enums.TipoTarjeta;

import java.util.*;

public class Venta {

    public Venta(int ventaID, Date fchVenta, List<Combo> combos, Funcion funcion) {
    	this.combos = combos;
    	this.funcion = funcion;
    	this.fchVenta = fchVenta;
    }

    private int ventaID;

    private Date fchVenta;

    private List<Combo> combos;

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    private Funcion funcion;

    public TarjetaDescuento getTarjetaDescuento() {
        return tarjetaDescuento;
    }

    private TarjetaDescuento tarjetaDescuento;

    public int getFuncionID() {
        return funcion != null ? funcion.getFuncionID() : -1;
    }


    public float getTotal() {
        float total = 0f;

        if (funcion != null) {
            total += funcion.calcularMontoPorEntradaDeLaPelicula();
        }

        if (combos != null) {
            for (Combo combo : combos) {
                total += combo.getPrecio();
            }
        }

        return total;
    }

    public int getPeliculaID() {
        return funcion != null && funcion.getPelicula() != null ? funcion.getPelicula().getPeliculaID() : -1;
    }
    public TipoTarjeta getTipoTarjeta() {
        return tarjetaDescuento != null ? tarjetaDescuento.getTipoTarjeta() : null;
    }

    public List<Combo> getListaComboID() {
		return combos;
    }

    public float calcularMontoPorComboDeVenta(){
        float total=  0.0f;
        for (Combo combo:getListaComboID()) {
           total +=  (combo.getPrecio()-(combo.getPrecio()*
                   CondicionesDescuento.getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta())));
        }
        return total;
    }


    public float calcularMontoDeLaVentaPorFuncionCombos() {
        float total = 0f;

        if (funcion != null) {

            total += funcion.calcularMontoPorEntradaDeLaPelicula();
        }

        if (combos != null) {
            for (Combo combo : combos) {
                total += combo.getPrecio();
            }
        }

        return total;
    }

}