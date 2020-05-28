package ejercicio1.modelo;

public class Ordenador {
    private int id;
    private int ram;
    private int ssd;

    public Ordenador(int id, int ram, int ssd) {
        this.id = id;
        this.ram = ram;
        this.ssd = ssd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return String.format("%d, %d, %d", id, ram, ssd);
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }
}
