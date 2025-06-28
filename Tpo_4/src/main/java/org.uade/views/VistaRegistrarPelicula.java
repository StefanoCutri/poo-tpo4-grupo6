package org.uade.views;

import org.uade.controllers.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.models.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VistaRegistrarPelicula extends JPanel {

    private JTextField nombreField;
    private JTextField directorField;
    private JTextField duracionField;
    private JComboBox<TipoGenero> generoComboBox;
    private JComboBox<TipoProyeccion> proyeccionComboBox;
    private JTextField actoresField; // texto separado por comas

    private final PeliculasController peliculasController = PeliculasController.getInstance();

    public VistaRegistrarPelicula() {
        setLayout(new GridLayout(8, 2, 10, 10));

        // Campos
        nombreField = new JTextField();
        directorField = new JTextField();
        duracionField = new JTextField();
        generoComboBox = new JComboBox<>(TipoGenero.values());
        proyeccionComboBox = new JComboBox<>(TipoProyeccion.values());
        actoresField = new JTextField();

        // Botón
        JButton registrarButton = new JButton("Registrar Película");
        registrarButton.addActionListener(this::registrarPelicula);

        // componentes
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Director:"));
        add(directorField);
        add(new JLabel("Duración (minutos):"));
        add(duracionField);
        add(new JLabel("Género:"));
        add(generoComboBox);
        add(new JLabel("Tipo de Proyección:"));
        add(proyeccionComboBox);
        add(new JLabel("Actores (separados por coma):"));
        add(actoresField);

        // Espacio vacío + botón
        add(new JLabel());
        add(registrarButton);
    }

    private void registrarPelicula(ActionEvent e) {
        String nombre = nombreField.getText();
        String director = directorField.getText();
        String duracionStr = duracionField.getText();
        TipoGenero genero = (TipoGenero) generoComboBox.getSelectedItem();
        TipoProyeccion tipo = (TipoProyeccion) proyeccionComboBox.getSelectedItem();
        String actoresStr = actoresField.getText();

        if (nombre.isEmpty() || director.isEmpty() || duracionStr.isEmpty() || genero == null || tipo == null || actoresStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completá todos los campos.");
            return;
        }

        try {
            int duracion = Integer.parseInt(duracionStr);
            List<String> actores = List.of(actoresStr.split("\\s*,\\s*"));

            Pelicula nuevaPelicula = new Pelicula(genero, director, duracion, nombre, tipo, actores, null);
            nuevaPelicula.setPeliculaID(peliculasController.generarNuevoID());

            peliculasController.registrarPelicula(nuevaPelicula);

            System.out.println("Películas registradas:");
            for (Pelicula p : peliculasController.getTodasLasPeliculas()) {
                System.out.println(p);
            }

            JOptionPane.showMessageDialog(this, "Película registrada con éxito.");
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La duración debe ser un número.");
        }
    }

    private void limpiarCampos() {
        nombreField.setText("");
        directorField.setText("");
        duracionField.setText("");
        actoresField.setText("");
        generoComboBox.setSelectedIndex(0);
        proyeccionComboBox.setSelectedIndex(0);
    }
}
