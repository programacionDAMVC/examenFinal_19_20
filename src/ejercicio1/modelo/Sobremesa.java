package ejercicio1.modelo;

public class Sobremesa extends Ordenador{
    private boolean servidor;

    public Sobremesa(int id, int ram, int ssd, boolean servidor) {
        super(id, ram, ssd);
        this.servidor = servidor;
    }

    public boolean isServidor() {
        return servidor;
    }

    public void setServidor(boolean servidor) {
        this.servidor = servidor;
    }
    @Override
    public String toString() {
        return String.format("%s, %b", super.toString(), servidor) ;
    }
}
