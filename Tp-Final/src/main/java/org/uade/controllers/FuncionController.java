package org.uade.controllers;

import org.uade.dtos.FuncionDto;
import org.uade.enums.TipoGenero;
import org.uade.models.Funcion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncionController {

    private List<Funcion> funcions;
    private static FuncionController INSTANCE = null;

    private FuncionController() {
        this.funcions = new ArrayList<>();

    }

    // Singleton
    public static synchronized FuncionController getInstances(){
        if(INSTANCE == null){
            INSTANCE = new FuncionController();
        }
        return INSTANCE;
    }


    // metodos
    public void AMB(){

    }

    public int obtenerAsientosDisponiblesPorFuncion(int idFuncion){
        return 0;
    }

    public List<FuncionDto> getListaFunciones(Date fechaInicio, Date fechaFin){
        return null;
    }

    public int peliculaMasVista(){
        return 0;
    }

    public int diaDeLaSemanaConMenorVentas(){
        return 0;
    }

    public List<Funcion> buscarPeliculaPorFuncion(int idFuncion){
        return null;
    }

    public List<Funcion> buscarPeliculaPorGeneroFuncion(TipoGenero genero){
        return null;
    }
}
