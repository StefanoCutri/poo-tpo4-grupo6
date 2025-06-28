package org.uade.views;

import org.uade.controllers.FuncionController;

import javax.swing.*;

public class VistaMenuPrincipal extends JFrame {

        public VistaMenuPrincipal() {

            FuncionController controller = FuncionController.getInstance();

            setTitle("Sistema Alquiler de motos");
            setSize(900, 1500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JTabbedPane tabbedPane = new JTabbedPane();

            VistaRegistrarFuncion panelRegistrarFuncion = new VistaRegistrarFuncion();
            VistaRegistrarPelicula panelRegistrarPelicula = new VistaRegistrarPelicula();
            VistaConsultarPeliculas panelConsultarPeliculas = new VistaConsultarPeliculas();
            JPanel panelGenerarReporte = new VistaGenerarReporte();


            tabbedPane.addTab("Registrar Función", panelRegistrarFuncion);
            tabbedPane.addTab("Registrar Pelicula", panelRegistrarPelicula);
            tabbedPane.addTab("Consultar Películas", panelConsultarPeliculas);
            tabbedPane.addTab("Reporte de Recaudación", panelGenerarReporte);


            tabbedPane.addChangeListener(e -> {
                int index = tabbedPane.getSelectedIndex();
                String title = tabbedPane.getTitleAt(index);
                if (title.equals("Registrar Función")) {
                    panelRegistrarFuncion.actualizarPeliculas();
                }
            });

            add(tabbedPane);
            setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new VistaMenuPrincipal());
        }


}
