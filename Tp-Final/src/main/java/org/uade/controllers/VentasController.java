package org.uade.controllers;

import org.uade.dtos.FuncionDto;
import org.uade.dtos.VentaDto;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoTarjeta;
import org.uade.models.Funcion;
import org.uade.models.Venta;

import java.util.ArrayList;
import java.util.List;

public class VentasController {
    private List<Venta> ventas;
    private static VentasController INSTANCE = null;

    private VentasController() {
        this.ventas = new ArrayList<>();

    }

    // Singleton
    public static synchronized VentasController getInstances(){
        if(INSTANCE == null){
            INSTANCE = new VentasController();
        }
        return INSTANCE;
    }


    // metodos
    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public float recaudacionPorFuncion(int idFuncion){
        return 0;
    }
    public float recaudacionPorPelicula(int idPelicula){
        return 0;
    }

    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta){
        return 0;
    }

    public void comboMasVendido(){

    }

    private Venta buscarVentaPorFuncion(Funcion funcion){
        return null;
    }

    public List<VentaDto> funcionesVendidasPorGenero(TipoGenero genero){
        return null;
    }

    public VentaDto modelVentaToDto(Venta venta){
        return null;
    }

    public FuncionDto modelFuncionToDto(Funcion funcion){
        return null;
    }
}
