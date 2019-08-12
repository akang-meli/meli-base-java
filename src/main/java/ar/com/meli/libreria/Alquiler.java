package ar.com.meli.libreria;

import java.time.Instant;
import java.util.Date;
import java.util.function.Predicate;

public class Alquiler {

    Alquilable alquilable;
    Date fechaAquiler;
    Date fechaDevolucion;


    public String getNombre() {
        return this.alquilable.getNombre();
    }

    public Alquiler(Alquilable alquilable, Date fechaDevolucion) {
        this.alquilable = alquilable;
        this.fechaAquiler = Date.from(Instant.now());
        this.fechaDevolucion = fechaDevolucion;
    }

}
