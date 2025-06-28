package org.uade.views;

import org.uade.controllers.FuncionController;
import org.uade.controllers.VentasController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VistaGenerarReporte extends JPanel {

    private JTextArea resultadoArea;
    private JButton generarReporteButton;
    private FuncionController funcionController = FuncionController.getInstance();

    public VistaGenerarReporte() {
        setLayout(new GridLayout(3, 1, 10, 10));

        resultadoArea = new JTextArea(10, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setText("Resultado\nHacé clic en el botón para generar el reporte.");
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        generarReporteButton = new JButton("Generar Reporte de Recaudación");
        generarReporteButton.setPreferredSize(new Dimension(250, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(generarReporteButton);

        generarReporteButton.addActionListener(e -> generarReporte());

        add(scrollPane);
        add(Box.createVerticalStrut(10)); // espacio vacío
        add(buttonPanel);

        // Simular ventas
        VentasController.getInstances().simularVentas();
    }

    private void generarReporte() {
        resultadoArea.setText("");

        List<String> recaudaciones = funcionController.obtenerRecaudacionesPorPelicula();

        if (recaudaciones.isEmpty()) {
            resultadoArea.setText("No hay recaudaciones disponibles.");
            System.out.println("Lista vacía de recaudaciones.");
        } else {
            System.out.println("Recaudaciones encontradas:");
            for (String r : recaudaciones) {
                resultadoArea.append(r + "\n");
                System.out.println(r);
            }
        }
    }
}
