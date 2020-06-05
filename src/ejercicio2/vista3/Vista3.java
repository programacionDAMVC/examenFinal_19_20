package ejercicio2.vista3;

import ejercicio2.modelo.Ordenador;
import ejercicio2.modelo.OrdenadorDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Vista3 extends JFrame {

    private OrdenadorDAO ordenadorDAO = new OrdenadorDAO();
    private List<Ordenador> listaOrdenadores = ordenadorDAO.listarTodosOrdenadores();
    private int contador = 0;
    private JTextField inputID, inputRAM, inputSSD, inputPULG;
    private Font font1 = new Font("Agency FB", Font.BOLD, 14);
    private JLabel etiquetaID;
    private JLabel etiquetaRAM;
    private JLabel etiquetaSSD;
    private JLabel etiquetaPULG;
    private JLabel etiquetaVacia;
    private JButton botonAvanzar;
    private JButton botonAvanzar10;
    private JButton botonRetroceder;
    private JButton botonRetroceder10;
    private JButton botonCrear;
    private JButton botonActualizar;
    private JButton botonBorrar;
    private JButton botonSalir;

    public Vista3 () {

        super("Aula de departamento");

        setVentana();
        Container cp = setLayout();
        crearPanelSuperior(cp);
        crearPanelInferior(cp);
        crearPanelCentral(cp);

    }

    private void setVentana() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); //obtener características pantalla
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 3,height / 3); //tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private Container setLayout() {
        //obtener el panel donde van a ir los componentes
        Container cp = getContentPane();
        //layout elegido, layout es la forma de disponer los componentes
        BorderLayout layoutPrincipal = new BorderLayout();
        cp.setLayout(layoutPrincipal);
        return cp;
    }

    private void crearPanelSuperior(Container cp) {
        //PANEL SUPERIOR
        JPanel panelSuperior = new JPanel();
        JLabel etiquetaSuperior = new JLabel("DATOS DE ORDENADORES");
        etiquetaSuperior.setFont(font1);
        panelSuperior.add(etiquetaSuperior);
        cp.add(panelSuperior, BorderLayout.NORTH);
    }

    private void crearPanelInferior(Container cp) {
        //PANEL INFERIOR
        JPanel panelInferior = new JPanel();

        crearBotonesPanelInferior();
        crearEventosBotonPanelInferior();
        disponerBotoneraPanelInferior(panelInferior);

        cp.add(panelInferior, BorderLayout.SOUTH);
    }

    private void crearPanelCentral(Container cp) {

        //PANEL CENTRAL
        JPanel panelCentral = new JPanel();
        GridLayout layoutCentral = new GridLayout(6,2);
        layoutCentral.setVgap(5);
        layoutCentral.setHgap(5);
        panelCentral.setLayout(layoutCentral);

        crearEtiquetasPanelCentral();
        cearFormularioPanelCentral();
        disponerComponentesPanelCentral(panelCentral);

        cp.add(panelCentral, BorderLayout.CENTER);
    }

    private void crearBotonesPanelInferior() {
        botonAvanzar = new JButton(">");
        botonAvanzar10 = new JButton(">>");
        botonRetroceder = new JButton("<");
        botonRetroceder10 = new JButton("<<");
        botonCrear = new JButton("crear");
        botonActualizar = new JButton("actualizar");
        botonBorrar = new JButton("borrar");
        botonSalir = new JButton("salir");
    }

    private void crearEventosBotonPanelInferior() {
        botonAvanzar.addActionListener(actionEvent -> {
            contador++;
            if (contador >= listaOrdenadores.size()) {
                contador %= listaOrdenadores.size();
            }
            setDatosFormularioPanelCentral(listaOrdenadores.get(contador));
        });
        botonAvanzar10.addActionListener(actionEvent -> {
            contador += 10;
            if (contador >= listaOrdenadores.size()) {
                contador %= listaOrdenadores.size();
            }
            setDatosFormularioPanelCentral(listaOrdenadores.get(contador));
        });
        botonRetroceder.addActionListener(actionEvent -> {
            contador--;
            if (contador < 0) {
                contador += listaOrdenadores.size() ;
            }
            setDatosFormularioPanelCentral(listaOrdenadores.get(contador));
        });
        botonRetroceder10.addActionListener(actionEvent -> {
            contador -= 10;
            if (contador < 0) {
                contador += listaOrdenadores.size() ;
            }
            setDatosFormularioPanelCentral(listaOrdenadores.get(contador));
        });

        botonCrear.addActionListener(actionEvent -> {
            int ram, ssd, pulg;
            String sRam = "";
            while (true) {
                sRam = JOptionPane.showInputDialog("Introduce ram");
                if (sRam != null && sRam.matches("[0-9]+")) {
                    ram = Integer.parseInt(sRam);
                    break;
                }
            }
            String sSSD = "";
            while (true) {
                sSSD = JOptionPane.showInputDialog("Introduce ssd");
                if (sSSD != null && sSSD.matches("[0-9]+")) {
                    ssd = Integer.parseInt(sSSD);
                    break;
                }
            }
            String sPulg = "";
            while (true) {
                sPulg = JOptionPane.showInputDialog("Introduce ssd");
                if (sPulg != null && sPulg.matches("[0-9]+")) {
                    pulg = Integer.parseInt(sPulg);
                    break;
                }
            }
            Ordenador ordenador = new Ordenador(ram, ssd, pulg);
            ordenadorDAO.crearOrdeandor(ordenador);
            //listaOrdenadores.add(ordenador);
            listaOrdenadores = ordenadorDAO.listarTodosOrdenadores();
            contador = listaOrdenadores.size() - 1;
            setDatosFormularioPanelCentral(listaOrdenadores.get(contador));

        });
        botonActualizar.addActionListener(actionEvent -> {
            int ramActual = Integer.parseInt(inputRAM.getText());
            String sRamNueva = "";
            while (true) {
                sRamNueva = JOptionPane.showInputDialog("Introduce ram a añadir");
                if (sRamNueva != null && sRamNueva.matches("[0-9]+")) {
                    int iRamNueva = Integer.parseInt(sRamNueva);
                    int ram = ramActual + iRamNueva;
                    inputRAM.setText(ram + "");
                    int id = Integer.parseInt(inputID.getText());
                    ordenadorDAO.ampliarMemoriaRAMOrdenadorPorId(new Ordenador(id, ram, 0, 0));
                    break;
                }
            }

        });
        botonBorrar.addActionListener(actionEvent -> {
            int id = Integer.parseInt(inputID.getText());
            ordenadorDAO.borrarOrdenadorPorId(id);
            contador++;
            if (contador >= listaOrdenadores.size())
                contador %= listaOrdenadores.size();
            setDatosFormularioPanelCentral(listaOrdenadores.get(contador));
        });
        botonSalir.addActionListener(actionEvent -> {
            System.exit(0);
        });
    }

    private void setDatosFormularioPanelCentral(Ordenador ordenador) {
        inputID.setText(ordenador.getId() + "");
        inputRAM.setText(ordenador.getRam() + "");
        inputSSD.setText(ordenador.getSsd() + "");
        inputPULG.setText(ordenador.getPantalla() + "");
    }

    private void disponerBotoneraPanelInferior(JPanel panelInferior) {
        panelInferior.add(botonSalir);
        panelInferior.add(botonActualizar);
        panelInferior.add(botonRetroceder10);
        panelInferior.add(botonRetroceder);
        panelInferior.add(botonAvanzar);
        panelInferior.add(botonAvanzar10);
        panelInferior.add(botonCrear);
        panelInferior.add(botonBorrar);
    }

    private void crearEtiquetasPanelCentral() {
        etiquetaID = new JLabel("ID", SwingConstants.CENTER );
        etiquetaID.setFont(font1);
        etiquetaRAM = new JLabel("RAM", SwingConstants.CENTER );
        etiquetaRAM.setFont(font1);
        etiquetaSSD = new JLabel("SSD", SwingConstants.CENTER );
        etiquetaSSD.setFont(font1);
        etiquetaPULG = new JLabel("PULGADAS", SwingConstants.CENTER );
        etiquetaPULG.setFont(font1);
        etiquetaVacia = new JLabel("");
    }

    private void cearFormularioPanelCentral() {
        inputID = new JTextField(10);
        inputRAM = new JTextField(10);
        inputSSD = new JTextField(10);
        inputPULG = new JTextField(10);
        setDatosFormularioPanelCentral(listaOrdenadores.get(contador));
    }

    private void disponerComponentesPanelCentral(JPanel panelCentral) {
        panelCentral.add(etiquetaID);
        panelCentral.add(inputID);
        panelCentral.add(etiquetaRAM);
        panelCentral.add(inputRAM);
        panelCentral.add(etiquetaSSD);
        panelCentral.add(inputSSD);
        panelCentral.add(etiquetaPULG);
        panelCentral.add(inputPULG);
        panelCentral.add(etiquetaVacia);
        panelCentral.add(etiquetaVacia);
        panelCentral.add(etiquetaVacia);
        panelCentral.add(etiquetaVacia);
    }
}
