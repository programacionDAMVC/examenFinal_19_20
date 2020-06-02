package ejercicio2.vista3;

import javax.swing.*;
import java.awt.*;


public class Vista3 extends JFrame {
    public Vista3 () {
        super("Titulo de la ventana");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //obtener el panel donde van a ir los componentes
        Container cp = getContentPane();
        //layout elegido, layout es la forma de disponer los componentes
        BorderLayout layoutPrincipal = new BorderLayout();
        cp.setLayout(layoutPrincipal);
        //PANEL SUPERIOR
        JPanel panelSuperior = new JPanel();
        JLabel etiquetaSuperior = new JLabel("TEXTO DE LA ETIQUETA");
        panelSuperior.add(etiquetaSuperior);
        cp.add(panelSuperior, BorderLayout.NORTH);
        //PANEL INFERIOR
        JPanel panelInferior = new JPanel();
        JButton botonAvanzar = new JButton(">>");
        JButton botonRetroceder = new JButton("<<");
        panelInferior.add(botonRetroceder);
        panelInferior.add(botonAvanzar);
        cp.add(panelInferior, BorderLayout.SOUTH);
        //PANEL CENTRAL
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(4,2));
        JLabel etiquetaID = new JLabel("ID");
        JLabel etiquetaRAM = new JLabel("RAM");
        JLabel etiquetaSSD = new JLabel("SSD");
        JLabel etiquetaPULG= new JLabel("PULG");
        JTextField inputID = new JTextField(10);
        JTextField inputRAM = new JTextField(10);
        JTextField inputSSD = new JTextField(10);
        JTextField inputPULG = new JTextField(10);
        panelCentral.add(etiquetaID); panelCentral.add(inputID);
        panelCentral.add(etiquetaRAM); panelCentral.add(inputRAM);
        panelCentral.add(etiquetaSSD); panelCentral.add(inputSSD);
        panelCentral.add(etiquetaPULG); panelCentral.add(inputPULG);
        cp.add(panelCentral, BorderLayout.CENTER);


    }
}
