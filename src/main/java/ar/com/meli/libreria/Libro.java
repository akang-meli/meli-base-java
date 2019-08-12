package ar.com.meli.libreria;

public  class Libro {

    boolean alquilado;
    String editorial;
    String titulo;

    public Libro(String editorial, String titulo) {
        this.editorial = editorial;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getNombre() {
        return this.getTitulo();
    }
}
