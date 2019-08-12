package ar.com.meli.libreria;

public class Novela extends Libro implements Alquilable {
    boolean alquilado;

    public Novela(String editorial, String titulo) {
        super(editorial, titulo);
    }

    @Override
    public void alquilar() {
        this.alquilado = true;
    }
}
