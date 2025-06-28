package org.uade.views;

import org.uade.controllers.FuncionController;
import org.uade.controllers.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.models.Funcion;
import org.uade.models.Pelicula;
import org.uade.models.Sala;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VistaRegistrarFuncion extends JPanel {

    private JComboBox<TipoGenero> generoComboBox;
    private JComboBox<Pelicula> peliculaComboBox;
    private JTextField salaTextField;
    private JSpinner fechaHoraSpinner;
    private JButton registrarButton;

    private PeliculasController peliculaController = PeliculasController.getInstance();
    private FuncionController funcionController = FuncionController.getInstance();

    public VistaRegistrarFuncion() {
        inicializarComponentes();
        cargarPeliculasEnCombo();
    }

    private void inicializarComponentes() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        generoComboBox = new JComboBox<>(TipoGenero.values());
        peliculaComboBox = new JComboBox<>();
        salaTextField = new JTextField(15);

        fechaHoraSpinner = new JSpinner(new SpinnerDateModel());
        fechaHoraSpinner.setEditor(new JSpinner.DateEditor(fechaHoraSpinner, "dd/MM/yyyy HH:mm"));

        registrarButton = new JButton("Registrar Función");

        // Fila 1: Género
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Género:"), gbc);

        gbc.gridx = 1;
        add(generoComboBox, gbc);

        // Fila 2: Película
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Película:"), gbc);

        gbc.gridx = 1;
        add(peliculaComboBox, gbc);

        // Fila 3: Sala
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Sala:"), gbc);

        gbc.gridx = 1;
        add(salaTextField, gbc);

        // Fila 4: Fecha y hora
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Fecha y Hora:"), gbc);

        gbc.gridx = 1;
        add(fechaHoraSpinner, gbc);

        // Fila 5: Botón
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registrarButton, gbc);

        // Listeners
        generoComboBox.addActionListener(e -> actualizarPeliculas());
        registrarButton.addActionListener(e -> registrarFuncion());

        actualizarPeliculas();
    }

    public void actualizarPeliculas() {
        peliculaComboBox.removeAllItems();
        TipoGenero genero = (TipoGenero) generoComboBox.getSelectedItem();
        if (genero != null) {
            List<Pelicula> peliculas = peliculaController.buscarPeliculasPorGenero(genero);
            for (Pelicula p : peliculas) {
                peliculaComboBox.addItem(p);
            }
        }
    }

    private void registrarFuncion() {
        Pelicula pelicula = (Pelicula) peliculaComboBox.getSelectedItem();
        String salaTexto = salaTextField.getText();
        Date fechaHora = (Date) fechaHoraSpinner.getValue();

        if (pelicula == null || salaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completá todos los campos.");
            return;
        }

        try {
            int salaID = Integer.parseInt(salaTexto);
            Sala sala = new Sala(salaID, "Sala A", 50);

            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            String horario = sdfHora.format(fechaHora);

            int nuevoID = funcionController.obtenerProximoID();

            Funcion nuevaFuncion = new Funcion(fechaHora, nuevoID, horario, new ArrayList<>(), sala, pelicula);
            boolean agregada = funcionController.agregarFuncion(nuevaFuncion);

            if (agregada) {
                JOptionPane.showMessageDialog(this, "Función registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe una función en ese horario y sala, o el ID está duplicado.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de sala debe ser un número.");
        }
    }

    private void cargarPeliculasEnCombo() {
        peliculaComboBox.removeAllItems(); // Limpiar primero
        List<Pelicula> peliculas = PeliculasController.getInstance().getTodasLasPeliculas();
        for (Pelicula pelicula : peliculas) {
            peliculaComboBox.addItem(pelicula); // Asumiendo que Pelicula tiene toString() overrideado
        }
    }


    private void limpiarCampos() {
        salaTextField.setText("");
        registrarButton.setText("");
    }
}
