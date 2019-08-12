package ar.com.meli.libreria;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;
import java.util.NoSuchElementException;

public class LibreriaTest {

    @Test
    public void crearLibreria() {
        Libreria libreria = Libreria.getInstance();
        Assertions.assertThat(libreria).isNotNull();
        Assertions.assertThat(libreria.getAquileres()).isEmpty();
        libreria.deleteInstance();
    }


    @Test
    public void agregandoUnAquiler() {
        Libreria libreria = Libreria.getInstance();
        Assertions.assertThat(libreria).isNotNull();
        Assertions.assertThat(libreria.getAquileres()).isEmpty();
        Alquilable alquilable = new Novela("Pepito", "Harry Potter");
        Alquiler alquiler = new Alquiler(alquilable, Date.from(Instant.now()));
        libreria.addAquiler(alquiler);
        Assertions.assertThat(libreria.getAquileres().size()).isEqualTo(1);
        libreria.deleteInstance();
    }

    @Test
    public void buscarAlquiler() {
        Libreria libreria = Libreria.getInstance();
        Alquilable alquilable = new Novela("Pepito", "Harry Potter");
        Alquiler alquiler = new Alquiler(alquilable, Date.from(Instant.now()));
        libreria.addAquiler(alquiler);

        // Encuentra el alquiler con el mismo nombre
        Assertions.assertThat(libreria.buscarAlquiler("Harry Potter")).isNotNull();
        // Lanza excepción si no encuentra
        boolean catcheo = false;
        try {
            libreria.buscarAlquiler("No Es Harry Potter");
        }
        catch(NoSuchElementException e) {
            catcheo = true;
        }
        Assertions.assertThat(catcheo).isTrue();

        libreria.deleteInstance();
    }

    @Test
    public void agregarLibro(){
        Libreria libreria = Libreria.getInstance();
        Libro libro = new Libro("Pepito","Harry Potter");
        libreria.addLibro(libro);
        Assertions.assertThat(libreria.getLibros().size()).isEqualTo(1);
        libreria.deleteInstance();
    }

}
