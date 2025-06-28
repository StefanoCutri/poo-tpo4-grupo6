package org.uade.views;

import org.uade.controllers.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.models.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class VistaConsultarPeliculas extends JPanel {

    private JComboBox<TipoGenero> generoComboBox;
    private JTextArea resultadoTextArea;
    private JButton consultarButton;
    private PeliculasController peliculasController;

    public VistaConsultarPeliculas() {
        peliculasController = PeliculasController.getInstance();

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        generoComboBox = new JComboBox<>(TipoGenero.values());
        consultarButton = new JButton("Consultar");

        topPanel.add(new JLabel("Seleccioná un género:"));
        topPanel.add(generoComboBox);
        topPanel.add(consultarButton);

        add(topPanel, BorderLayout.NORTH);

        resultadoTextArea = new JTextArea(15, 40);
        resultadoTextArea.setEditable(false);
        add(new JScrollPane(resultadoTextArea), BorderLayout.CENTER);

        consultarButton.addActionListener(this::consultarPeliculas);
    }

    private void consultarPeliculas(ActionEvent e) {
        resultadoTextArea.setText("");

        TipoGenero generoSeleccionado = (TipoGenero) generoComboBox.getSelectedItem();
        if (generoSeleccionado != null) {
            List<Pelicula> peliculas = peliculasController.buscarPeliculasPorGenero(generoSeleccionado);
            if (peliculas.isEmpty()) {
                resultadoTextArea.setText("No hay películas registradas para ese género.");
            } else {
                for (Pelicula p : peliculas) {
                    resultadoTextArea.append(p.toString() + "\n");
                }
            }
        }
    }
}
