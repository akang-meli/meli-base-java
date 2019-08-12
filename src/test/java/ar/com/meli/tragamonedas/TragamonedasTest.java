package ar.com.meli.tragamonedas;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class TragamonedasTest {

    public ArrayList<Tambor> getTambores() {
        ArrayList<Tambor> tambores = new ArrayList<Tambor>(3);
        for (int i = 0; i < 3 ; i++) {
            Tambor tambor = new Tambor();
            tambores.add(tambor);
        }
        return tambores;
    }

    public ArrayList<Tambor> getMockedTambores() {
        ArrayList<Tambor> tambores = new ArrayList<Tambor>(3);
        for (int i = 0; i < 3 ; i++) {
            Tambor tambor = mock(Tambor.class);
            when(tambor.obtenerPosicion()).thenReturn(1);
            tambores.add(tambor);
        }
        return tambores;
    }
    @Test
    public void crearTragamonedas() {
        Tragamonedas tragamonedas = new Tragamonedas(this.getTambores());
        Assertions.assertThat(tragamonedas).isNotNull();
        Assertions.assertThat(tragamonedas.getActivations()).isEqualTo(0);
        Assertions.assertThat(tragamonedas.getTambores().size()).isEqualTo(3);
    }

    @Test
    public void activarTragamonedas() {
        Tragamonedas tragamonedas = new Tragamonedas(this.getTambores());
        tragamonedas.activate();
        Assertions.assertThat(tragamonedas.getActivations()).isEqualTo(1);
    }

    @Test
    public void ganadorObtienePremio() {
        Tragamonedas tragamonedas = new Tragamonedas(this.getMockedTambores());
        tragamonedas.activate();
        Assertions.assertThat(tragamonedas.getPremioEntregado()).isEqualTo(1000);
    }

    @Test
    public void seGiranLosTambores() {
        Tragamonedas tragamonedas = new Tragamonedas(this.getMockedTambores());
        tragamonedas.activate();
        for (Tambor tambor: tragamonedas.getTambores()) {
            verify(tambor, times(1)).girar();
        }
    }
}
