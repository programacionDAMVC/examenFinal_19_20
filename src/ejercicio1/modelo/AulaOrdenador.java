package ejercicio1.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AulaOrdenador {
    private String nombreAula;
    private List<Ordenador> ordenadores;

    public AulaOrdenador(String nombreAula, List<Ordenador> ordenadores) {
        this.nombreAula = nombreAula;
        this.ordenadores = ordenadores;
    }
    public boolean ampliarMemoriaRAM(Ordenador ordenador, int ram) {
        for (Ordenador computador: ordenadores) {
            if (computador.getId() == ordenador.getId()){
                computador.setRam(computador.getRam() + ram);
                return true;
            }
        }
        return false;
    }
    public List<Ordenador> obtenerOrdenadoresSegunCaracteristicas(int ram, int ssd) {
        List<Ordenador> listaOrdenadores = new ArrayList<>();
        for (Ordenador computador: ordenadores) {
            if (computador.getRam() == ram && computador.getSsd() == ssd)
                listaOrdenadores.add(computador);
        }
        return listaOrdenadores;
    }
    public static List<Ordenador> leerFichero(String pathFichero) throws IOException {
        List<Ordenador> listaOrdenadores = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Paths.get(pathFichero));
        lineas.remove(0);
        for (String linea: lineas) {
            String[] tokens = linea.split(",");
            if (tokens[3].matches("[\\d]+"))
                listaOrdenadores.add(new Portatil(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
            else
                listaOrdenadores.add(new Sobremesa(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]), Boolean.parseBoolean(tokens[3])));

        }
        return listaOrdenadores;
    }
    public void grabarDatos() throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ficherosSalida/ordenadores_" +
                LocalDate.now() + ".csv")));
        for (Ordenador ordenador: ordenadores) {
            out.println(ordenador);
            out.flush();
        }
    }

    public static void main(String[] args) throws IOException {

        List<Ordenador> ordenadorer = leerFichero("ficherosEntrada/ordenadores.csv");
        AulaOrdenador aulaOrdenador = new AulaOrdenador("1.1", ordenadorer);
        System.out.printf("Ampliada memoria: %B%n", aulaOrdenador.ampliarMemoriaRAM(
                aulaOrdenador.ordenadores.get(99), 64));
        aulaOrdenador.obtenerOrdenadoresSegunCaracteristicas(128, 3000).forEach(System.out::println);
        aulaOrdenador.grabarDatos();
    }
}
