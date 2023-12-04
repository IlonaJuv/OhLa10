package test.java;

import main.java.kivipaperisakset.Pelaaja;
import main.java.kivipaperisakset.Vakiot;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class PelaajaTest {
    Vakiot vakiot;
    Pelaaja pelaaja;
    @Test
    public void testPelaajanValinta() {
        pelaaja = new Pelaaja();
        String valinta = pelaaja.pelaajanValinta();
        assertNotNull(valinta);
        assertTrue(valinta.equals(vakiot.KIVI) || valinta.equals(vakiot.PAPERI) || valinta.equals(vakiot.SAKSET));
    }

    @Test
    public void testSetVoitot() {
        pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
        pelaaja.setVoitot();
        assertEquals(1, pelaaja.getVoitot());
    }

    @Test
    public void testGetVoitot() {
        pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
        pelaaja.setVoitot();
        assertEquals(1, pelaaja.getVoitot());
    }
}
