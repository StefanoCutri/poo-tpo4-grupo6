package org.uade.controllers;
import org.uade.dtos.FuncionDTO;
import org.uade.dtos.VentaDto;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoTarjeta;
import org.uade.models.Combo;
import org.uade.models.Funcion;
import org.uade.models.Venta;

import java.util.*;


/**
 * 
 */
public class VentasController {

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * Default constructor
     */
    private List<Venta> ventas;

    private FuncionController funcionController = FuncionController.getInstance();

    public VentasController(){
        ventas = new ArrayList<Venta>();
        Venta venta = new Venta(1,new Date(), null, null);
        ventas.add(venta);
    }

    private static VentasController INSTANCE = null;

    // Singleton
    public static synchronized VentasController getInstances(){
        if(INSTANCE == null){
            INSTANCE = new VentasController();
        }
        return INSTANCE;
    }

    /**
     * @param funcionID 
     * @return
     */
    public float recaudacionPorFuncion(int funcionID) {
        Funcion funciones = funcionController.buscarFuncionPorID(funcionID);
        if(funciones == null){
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (Venta venta : ventas) {
            if (venta.getFuncion() != null && venta.getFuncion().getFuncionID() == funcionID) {
                totalrecuadado += venta.calcularMontoDeLaVentaPorFuncionCombos();
            }
        }
        return totalrecuadado;
    }

    /**
     * Caso de secuencia a desarrollar
     * @param peliculaID
     * @return
     */
    public float recaudacionPorPelicula(int peliculaID) {
        List<Funcion> funciones = funcionController.buscarPeliculaPorFuncion(peliculaID);
        if(funciones.isEmpty()){
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (Funcion funcion:funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(!Objects.isNull(venta)){
                totalrecuadado+=venta.calcularMontoDeLaVentaPorFuncionCombos();
            }
        }
    	return totalrecuadado;
    }

    /**
     * @param tipoTarjeta 
     * @return
     */
    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        float total = 0.0f;
        for (Venta venta : ventas) {
            if (venta.getTarjetaDescuento() != null && venta.getTarjetaDescuento().getTipoTarjeta().equals(tipoTarjeta)) {
                total += venta.calcularMontoDeLaVentaPorFuncionCombos();
            }
        }
        return total;
    }

    /**
     * 
     */
    public void comboMasVendido() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        int comboMasVendidoID = -1;
        int maxCantidad = 0;

        for (Venta venta : ventas) {
            if (venta.getListaComboID() == null) continue;

            for (Combo combo : venta.getListaComboID()) {
                int comboID = combo.getComboID();
                int cantidad = 0;

                for (Venta v : ventas) {
                    if (v.getListaComboID() != null) {
                        for (Combo c : v.getListaComboID()) {
                            if (c.getComboID() == comboID) {
                                cantidad++;
                            }
                        }
                    }
                }

                if (cantidad > maxCantidad) {
                    maxCantidad = cantidad;
                    comboMasVendidoID = comboID;
                }
            }
        }

        if (comboMasVendidoID != -1) {
            System.out.println("Combo más vendido: ID " + comboMasVendidoID + " (" + maxCantidad + " ventas)");
        } else {
            System.out.println("No se vendieron combos.");
        }
    }

    private  Venta buscarVentaPorFuncion(Funcion funcion){
        for (Venta venta:getVentas()) {
            if(Objects.equals(funcion,venta.getFuncion())){
                return venta;
            }
        }
        return null;
    }

    /**
     * View a desarrollar
     *
     * @param genero
     * @return
     */
    public List<VentaDto> funcionesVendidasPorGenero(TipoGenero genero) {
        List<VentaDto> ventaDtos = new ArrayList<>();
        List<Funcion> funciones = funcionController.buscarPeliculaPorGenerosFuncion(genero);
        if(funciones.isEmpty()){
            return ventaDtos;
        }
        for (Funcion funcion:funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(!Objects.isNull(venta)){
                ventaDtos.add(modelVentaToDto(venta));
            }
        }
        return ventaDtos;
    }

    public VentaDto modelVentaToDto(Venta venta){
        return new VentaDto(modelFuncionToDto(venta.getFuncion()));
    }

    public FuncionDTO modelFuncionToDto(Funcion funcion){
        return new FuncionDTO(funcion);
    }


    public void simularVentas() {
        List<Funcion> funciones = FuncionController.getInstance().getFunciones();
        System.out.println("🧪 Funciones disponibles para simular: " + funciones.size());

        for (Funcion f : funciones) {
            Venta venta = new Venta(1, new Date(), null, null);
            venta.setFuncion(f);
            ventas.add(venta);
        }

        System.out.println("🧪 Ventas simuladas: " + ventas.size());
    }


}