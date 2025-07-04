package org.uade.controllers;
import org.uade.models.Sala;
import org.uade.models.Sucursal;

import java.util.*;


/**
 * 
 */
public class SucursalController {

    private List<Sucursal> sucursales;
    private static SucursalController instancia;

    private SucursalController() {
        sucursales = new ArrayList<>();
        sucursales.add(new Sucursal(1, "Barracas", "Av Montes de Oca 1100", null));
    }

    public static SucursalController getInstance() {
        if (instancia == null) {
            instancia = new SucursalController();
        }
        return instancia;
    }

    public void agregarSucursal(int id, String denom, String dir) {
        for (Sucursal s : sucursales) {
            if (s.getSucursalID() == id) {
                System.out.println("Error: Ya existe una sucursal con ese ID.");
                return;
            }
        }

        Sucursal nueva = new Sucursal(id, denom, dir, new ArrayList<Sala>());
        sucursales.add(nueva);
        System.out.println("Sucursal agregada correctamente.");
    }


    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        for (Sucursal s : sucursales) {
            if (s.getSucursalID() == idSucursal) {
                if (s.getSalas() == null) {
                    s.setSalas(new ArrayList<>());
                }

                for (Sala sala : s.getSalas()) {
                    if (sala.getSalaID() == salaID) {
                        System.out.println("Error: Ya existe una sala con ese ID en la sucursal.");
                        return;
                    }
                }

                Sala nuevaSala = new Sala(salaID, denom, nroasientos);
                s.getSalas().add(nuevaSala);
                System.out.println("Sala agregada correctamente.");
                return;
            }
        }

        System.out.println("Error: No se encontró la sucursal con ese ID.");
    }


}