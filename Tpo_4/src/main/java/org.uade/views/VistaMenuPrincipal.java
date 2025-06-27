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

            JPanel panelRegistrarFuncion = new VistaRegistrarFuncion();
            tabbedPane.addTab("Registrar Función", panelRegistrarFuncion);

            JPanel panelRegistrarPelicula = new VistaRegistrarPelicula();
            tabbedPane.addTab("Registrar Pelicula", panelRegistrarPelicula);


            add(tabbedPane);

            setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new VistaMenuPrincipal());
        }


}
