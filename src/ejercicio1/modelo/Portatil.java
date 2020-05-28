package ejercicio1.modelo;

public class Portatil extends Ordenador {
    private int pantalla;

    public Portatil(int id, int ram, int ssd, int pantalla) {
        super(id, ram, ssd);
        this.pantalla = pantalla;
    }

    public int getPantalla() {
        return pantalla;
    }

    public void setPantalla(int pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", super.toString(), pantalla) ;
    }
}
