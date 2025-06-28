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

        // Área de resultados
        resultadoArea = new JTextArea(15, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setText("Resultado\nHacé clic en el botón para generar el reporte.");
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        // Botón
        generarReporteButton = new JButton("Generar Reporte de Recaudación");
        generarReporteButton.addActionListener(e -> generarReporte());

        // Agregamos componentes directamente al panel principal (como en tus otras vistas)
        add(scrollPane, BorderLayout.CENTER);
        add(generarReporteButton, BorderLayout.SOUTH);

        // Simular ventas al iniciar
        VentasController.getInstances().simularVentas();
        System.out.println("⚙️ VistaGenerarReporte creada y ventas simuladas.");
    }

    private void generarReporte() {
        resultadoArea.setText("");

        List<String> recaudaciones = funcionController.obtenerRecaudacionesPorPelicula();

        if (recaudaciones.isEmpty()) {
            resultadoArea.setText("No hay recaudaciones disponibles.");
            System.out.println("🟥 Lista vacía de recaudaciones.");
        } else {
            System.out.println("📊 Recaudaciones encontradas:");
            for (String r : recaudaciones) {
                resultadoArea.append(r + "\n");
                System.out.println(r);
            }
        }
    }
}
