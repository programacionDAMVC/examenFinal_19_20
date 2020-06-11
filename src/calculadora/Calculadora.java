package calculadora;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private StringBuilder sb = new StringBuilder();
    private JTextField display;
    private JButton boton7;
    private JButton boton8;
    private JButton boton9;
    private JButton botonMas;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JButton botonMenos;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton0;
    private JButton botonPor;
    private JButton botonDiv;
    private JButton botonResto;
    private JButton botonIgu;

    public Calculadora () {
        super();
        setVentana();
        Container cp = setLayout();
        crearPanelSuperior(cp);
        crearPanelCentral(cp);

    }

    private void setVentana() {
        setTitle("Calculador superbásica");
        setSize(450,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private Container setLayout() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        return cp;
    }

    private void crearPanelSuperior(Container cp) {
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(new EmptyBorder(10, 10, 10, 10));
        display = new JTextField("0", 20);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(Color.WHITE);
        display.setEditable(false);
        panelSuperior.add(display);
        cp.add(panelSuperior, BorderLayout.NORTH);
    }

    private void crearPanelCentral(Container cp) {

        JPanel panelCentral = new JPanel();
        panelCentral.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelCentral.setLayout(new GridLayout(4,4,10,10));

        crearBotonesPanelCentral();
        disponerBotoneraPanelCentral(panelCentral);
        cp.add(panelCentral,BorderLayout.CENTER);
        crearEventosBotonesPCentral();

    }

    private void crearBotonesPanelCentral() {
        boton7 = new JButton("7");
        boton8 = new JButton("8");
        boton9 = new JButton("9");
        botonMas = new JButton("+");
        boton4 = new JButton("4");
        boton5 = new JButton("5");
        boton6 = new JButton("6");
        botonMenos = new JButton("-");
        boton1 = new JButton("1");
        boton2 = new JButton("2");
        boton3 = new JButton("3");
        boton0 = new JButton("0");
        botonPor = new JButton("*");
        botonDiv = new JButton("/");
        botonResto = new JButton("%");
        botonIgu = new JButton("=");
    }

    private void disponerBotoneraPanelCentral(JPanel panelCentral) {
        panelCentral.add(boton7);
        panelCentral.add(boton8);
        panelCentral.add(boton9);
        panelCentral.add(botonMas);
        panelCentral.add(boton4);
        panelCentral.add(boton5);
        panelCentral.add(boton6);
        panelCentral.add(botonMenos);
        panelCentral.add(boton1);
        panelCentral.add(boton2);
        panelCentral.add(boton3);
        panelCentral.add(boton0);
        panelCentral.add(botonPor);
        panelCentral.add(botonDiv);
        panelCentral.add(botonResto);
        panelCentral.add(botonIgu);
    }

    private void crearEventosBotonesPCentral() {

        boton0.addActionListener(new EventosBotones());
        boton1.addActionListener(new EventosBotones());
        boton2.addActionListener(new EventosBotones());
        boton3.addActionListener(new EventosBotones());
        boton4.addActionListener(new EventosBotones());
        boton5.addActionListener(new EventosBotones());
        boton6.addActionListener(new EventosBotones());
        boton7.addActionListener(new EventosBotones());
        boton8.addActionListener(new EventosBotones());
        boton9.addActionListener(new EventosBotones());
        botonMas.addActionListener(new EventosBotones());
        botonMenos.addActionListener(new EventosBotones());
        botonDiv.addActionListener(new EventosBotones());
        botonResto.addActionListener(new EventosBotones());
        botonPor.addActionListener(new EventosBotones());
        botonIgu.addActionListener(new EventosBotones());

//        boton8.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "8")){
//                sb.append(8); display.setText(sb.toString());
//            }
//        });
//        boton9.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "9")){
//                sb.append(9); display.setText(sb.toString());
//            }
//        });
//        boton7.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "7")){
//                sb.append(7); display.setText(sb.toString());
//            }
//        });
//        boton6.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "6")){
//                sb.append(6); display.setText(sb.toString());
//            }
//        });
//        boton5.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "5")){
//                sb.append(5); display.setText(sb.toString());
//            }
//        });
//        boton4.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "4")){
//                sb.append(4); display.setText(sb.toString());
//            }
//        });
//        boton3.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "3")){
//                sb.append(3); display.setText(sb.toString());
//            }
//        });
//        boton2.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "2")){
//                sb.append(2); display.setText(sb.toString());
//            }
//        });
//        boton1.addActionListener(actionEvent -> {
//            if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "1")){
//                sb.append(1); display.setText(sb.toString());
//            }
//        });
//        botonMenos.addActionListener(actionEvent -> {
//            if ( sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + "-")){
//                sb.append('-'); display.setText(sb.toString());
//            }
//        });
//        boton0.addActionListener(actionEvent -> {
//            if (Auxiliar.comprobarExpresionAritmetica(sb.toString() + "0")){
//                sb.append(0); display.setText(sb.toString());
//            }
//        });
//        botonMas.addActionListener(actionEvent -> {
//            if (Auxiliar.comprobarExpresionAritmetica(sb.toString() + "+")){
//                sb.append('+'); display.setText(sb.toString());
//            }
//        });
//        botonDiv.addActionListener(actionEvent -> {
//            if (Auxiliar.comprobarExpresionAritmetica(sb.toString() + "/")){
//                sb.append('/'); display.setText(sb.toString());
//            }
//        });
//        botonPor.addActionListener(actionEvent -> {
//            if (Auxiliar.comprobarExpresionAritmetica(sb.toString() + "*")){
//                sb.append('*'); display.setText(sb.toString());
//            }
//        });
//        botonResto.addActionListener(actionEvent -> {
//            if (Auxiliar.comprobarExpresionAritmetica(sb.toString() + "-")){
//                sb.append('%'); display.setText(sb.toString());
//            }
//        });
//        botonIgu.addActionListener(actionEvent -> {
//            if (Auxiliar.comprobarParaIgual(sb.toString())){
//                display.setText(Auxiliar.obtenerOperacion(sb.toString()) + "");
//                sb = new StringBuilder();
//            }
//        });
    }

    class EventosBotones implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String boton = ((JButton) e.getSource()).getText();
            switch (boton) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "-":
                    if (sb.length() == 0 || Auxiliar.comprobarExpresionAritmetica(sb.toString() + boton )) {
                        sb.append(boton);
                        display.setText(sb.toString());
                    }
                    break;

                case "=":
                    if (Auxiliar.comprobarParaIgual(sb.toString())) {
                        display.setText(Auxiliar.obtenerOperacion(sb.toString()) + "");
                        sb = new StringBuilder();
                    }
                    break;

                default:
                    if (Auxiliar.comprobarExpresionAritmetica(sb.toString() + boton )) {
                        sb.append(boton);
                        display.setText(sb.toString());
                    }
            }

        }


    }
}
