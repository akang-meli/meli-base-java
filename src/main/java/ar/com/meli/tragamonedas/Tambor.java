package ar.com.meli.tragamonedas;

import java.util.Random;

public class Tambor {
    private Integer value;

    public Tambor() {
        this.value = 0;
    }

    private Integer getValue() {
        return this.value;
    }

    public void girar() {
        Random r = new Random();
        this.value = r.nextInt() % 8;
    }

    public Integer obtenerPosicion() {
        return this.value;
    }
}
