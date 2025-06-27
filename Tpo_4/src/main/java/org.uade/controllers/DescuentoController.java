package org.uade.controllers;
import org.uade.enums.TipoTarjeta;
import org.uade.models.CondicionesDescuento;
import org.uade.models.TarjetaDescuento;

import java.util.*;


public class DescuentoController {

	private static DescuentoController instancia;

	private List<CondicionesDescuento> descuentos;

	private DescuentoController() {
		descuentos = new ArrayList<>();
		CondicionesDescuento cd = new CondicionesDescuento(
				new Date(), new Date(), 5, 50, TipoTarjeta.PAMI, new ArrayList<TarjetaDescuento>());
		descuentos.add(cd);
	}

	public static DescuentoController getInstance() {
		if (instancia == null) {
			instancia = new DescuentoController();
		}
		return instancia;
	}
	
	public boolean agregarDescuento(CondicionesDescuento nuevo) {
		for (CondicionesDescuento c : descuentos) {
			if (c.equals(nuevo)) { // si tienes equals bien implementado
				System.out.println("Error: Ya existe esta condición de descuento.");
				return false;
			}
		}
		descuentos.add(nuevo);
		return true;
	}

	public boolean eliminarDescuento(CondicionesDescuento aEliminar) {
		boolean eliminado = descuentos.remove(aEliminar);
		if (!eliminado) {
			System.out.println("Error: No se encontró la condición para eliminar.");
		}
		return eliminado;
	}

	public boolean modificarDescuento(CondicionesDescuento viejo, CondicionesDescuento nuevo) {
		int idx = descuentos.indexOf(viejo);
		if (idx == -1) {
			System.out.println("Error: No se encontró la condición para modificar.");
			return false;
		}
		descuentos.set(idx, nuevo);
		return true;
	}

	public List<CondicionesDescuento> getDescuentos() {
		return new ArrayList<>(descuentos); // devuelvo copia para no exponer la lista interna
	}

}