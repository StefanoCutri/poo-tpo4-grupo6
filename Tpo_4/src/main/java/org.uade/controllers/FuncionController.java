package org.uade.controllers;

import org.uade.dtos.FuncionDTO;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.models.Entrada;
import org.uade.models.Funcion;
import org.uade.models.Pelicula;
import org.uade.models.Sala;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 */
public class FuncionController {

    private List<Funcion> funciones;

    private static FuncionController instancia;

    private FuncionController() {
        funciones = new ArrayList<>();
        // Inicialización de ejemplo
        funciones.add(new Funcion(new Date(), 1, "11:00", new ArrayList<>(),
                new Sala(0, null, 0),
                new Pelicula(TipoGenero.Terror,"steven spielberg",120,"Tiburon", TipoProyeccion.DosD,new ArrayList<>(),null)));
    }

    public static FuncionController getInstance() {
        if (instancia == null) {
            instancia = new FuncionController();
        }
        return instancia;
    }


    public boolean agregarFuncion(Funcion nuevaFuncion) {
        // Validar que no exista función con mismo ID
        for (Funcion f : funciones) {
            if (f.getFuncionID() == nuevaFuncion.getFuncionID()) {
                return false;
            }
        }

        for (Funcion f : funciones) {
            if (f.getSalaID() == nuevaFuncion.getSalaID()) {
                if (f.getFecha().equals(nuevaFuncion.getFecha())) {
                    return false;
                }
            }
        }

        funciones.add(nuevaFuncion);
        return true;
    }


    public boolean eliminarFuncion(int funcionID) {
        for (int i = 0; i < funciones.size(); i++) {
            if (funciones.get(i).getFuncionID() == funcionID) {
                funciones.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean modificarFuncion(Funcion funcionModificada) {
        for (int i = 0; i < funciones.size(); i++) {
            Funcion f = funciones.get(i);
            if (f.getFuncionID() == funcionModificada.getFuncionID()) {
                for (Funcion f2 : funciones) {
                    if (f2.getFuncionID() != funcionModificada.getFuncionID()) {
                        if (f2.getSalaID() == funcionModificada.getSalaID() &&
                                f2.getFecha().equals(funcionModificada.getFecha())) {
                            return false;
                        }
                    }
                }

                funciones.set(i, funcionModificada);
                return true;
            }
        }
        return false;
    }


    /**
     * @param funcionID 
     * @return
     */
    public int obtenerAsientosDisponiblePorFuncion(int funcionID) {
        for (Funcion f : funciones)
        {
            if (f.getFuncionID() == funcionID)
            {
                f.getCantidadAsientosDisponibles();
            }
        }
		return 0;
    }

    /**
     * @param fchFuncion 
     * @return
     */
    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {

        List<FuncionDTO> lista = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (Funcion f : funciones) {

            String fechaParametro = sdf.format(fchFuncion);
            String fechaLista = sdf.format(f.getFecha());
            if (fechaLista.equals(fechaParametro)) {
                lista.add(new FuncionDTO(f));
            }
        }
        return lista;
    }

    /**
     * @return
     */
    public int peliculaMasVista() {
        List<Integer> peliculas = new ArrayList<>();

        for (Funcion f : funciones) {
            int id = f.getPelicula().getPeliculaID();
            if (!peliculas.contains(id)) {
                peliculas.add(id);
            }
        }

        int maxID = -1;
        int maxEntradas = -1;

        for (int idPelicula : peliculas) {
            int totalEntradas = 0;
            for (Funcion f : funciones) {
                if (f.getPelicula().getPeliculaID() == idPelicula) {
                    totalEntradas += f.getEntradas().size();
                }
            }
            if (totalEntradas > maxEntradas) {
                maxEntradas = totalEntradas;
                maxID = idPelicula;
            }
        }

        return maxID;
    }


    /**
     * @return
     */
    public int diaDeLaSemanaConMenorVentas() {int[] ventasPorDia = new int[8];

        for (Funcion f : funciones) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(f.getFecha());
            int diaSemana = cal.get(Calendar.DAY_OF_WEEK);

            int entradasVendidas = f.getEntradas().size();
            ventasPorDia[diaSemana] += entradasVendidas;
        }

        int minDia = 1;
        int minVentas = ventasPorDia[1];

        for (int dia = 2; dia <= 7; dia++) {
            if (ventasPorDia[dia] < minVentas) {
                minVentas = ventasPorDia[dia];
                minDia = dia;
            }
        }

        return minDia;
    }



    public List<Funcion> buscarPeliculaPorFuncion(int peliculaID) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPeliculaID() == peliculaID){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funcionesDeLaPelicula;
    }

    public List<Funcion> buscarPeliculaPorGenerosFuncion(TipoGenero genero) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPelicula().getGenero() == genero){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funcionesDeLaPelicula;
    }

    public Funcion buscarFuncionPorID(int funcionID) {
        for (Funcion f : funciones) {
            if (f.getFuncionID() == funcionID) {
                return f;
            }
        }
        return null;
    }

    public int obtenerProximoID() {
        int maxID = 0;
        for (Funcion f : funciones) {
            if (f.getFuncionID() > maxID) {
                maxID = f.getFuncionID();
            }
        }
        return maxID + 1;
    }
}