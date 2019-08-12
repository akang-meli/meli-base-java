package ar.com.meli.libreria;

public class LibroEstudio extends Libro implements Alquilable {

    boolean alquilado;

    public LibroEstudio(String editorial, String titulo) {
        super(editorial, titulo);
    }

    @Override
    public void alquilar() {
        this.alquilado = true;
    }
}
