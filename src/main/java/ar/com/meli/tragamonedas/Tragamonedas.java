package ar.com.meli.tragamonedas;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Tragamonedas {
    private ArrayList<Tambor> tambores;
    private Integer activations;
    private Integer premioEntregado;

    public Tragamonedas(ArrayList<Tambor> tambores) {
        this.activations = 0;
        this.tambores = tambores;
        this.premioEntregado = 0;
    }

    public Integer getActivations() {
        return this.activations;
    }

    public ArrayList<Tambor> getTambores() {
        return this.tambores;
    }

    public void activate() {
        this.activations++;
        this.tambores
                .stream()
                .forEach(tambor -> tambor.girar());
        if(this.hasWon()) this.entregarPremio();
    }

    private boolean hasWon() {
        Integer posicionInicial = this.tambores.stream().findFirst().get().obtenerPosicion();
        System.out.println(posicionInicial);
        for (Tambor tambor: this.tambores) {
            if(!tambor.obtenerPosicion().equals(posicionInicial)) return false;
        }
        return true;
    }

    public void entregarPremio() {
        System.out.println("GANASTE 1000 PATACONES");
        this.premioEntregado += 1000;
    }

    public Integer getPremioEntregado() {
        return this.premioEntregado;
    }
}
