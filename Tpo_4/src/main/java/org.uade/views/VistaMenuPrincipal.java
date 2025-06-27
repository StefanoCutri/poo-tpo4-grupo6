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

            //JPanel panelMotoScooter = new AltaMotoScooter(controller);
            //JPanel panelCliente = new AltaCliente(controller);

            //tabbedPane.addTab("Registrar moto scooter", panelMotoScooter);
            //tabbedPane.addTab("Registrar cliente", panelCliente);


            add(tabbedPane);

            setVisible(true);
            setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new VistaMenuPrincipal());
        }


}
