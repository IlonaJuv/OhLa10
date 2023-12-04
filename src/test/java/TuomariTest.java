package test.java;

import main.java.kivipaperisakset.Pelaaja;
import main.java.kivipaperisakset.Tuomari;
import main.java.kivipaperisakset.Vakiot;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class TuomariTest {

    @Test
    public void testTarkistaTulos() {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();
        Tuomari tuomari = new Tuomari(pelaaja1, pelaaja2);

        assertEquals(Vakiot.TASAPELITEKSTI, tuomari.tarkistaTulos(Vakiot.KIVI, Vakiot.KIVI));
        assertEquals(Vakiot.P1_VOITTOTEKSTI, tuomari.tarkistaTulos(Vakiot.KIVI, Vakiot.SAKSET));
        assertEquals(Vakiot.P2_VOITTOTEKSTI, tuomari.tarkistaTulos(Vakiot.PAPERI, Vakiot.SAKSET));

    }

    @Test
    public void testGetTasapelit() {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();
        Tuomari tuomari = new Tuomari(pelaaja1, pelaaja2);

        assertEquals(0, tuomari.getTasapelit());
        tuomari.tarkistaTulos(Vakiot.KIVI, Vakiot.KIVI);
        assertEquals(1, tuomari.getTasapelit());
    }

    @Test
    public void testPeliLoppuu() {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();
        Tuomari tuomari = new Tuomari(pelaaja1, pelaaja2);

        assertFalse(tuomari.peliLoppuu());
        pelaaja1.setVoitot();
        pelaaja1.setVoitot();
        pelaaja1.setVoitot();
        assertTrue(tuomari.peliLoppuu());
    }
}
