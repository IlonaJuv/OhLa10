package test.java;

import main.java.kivipaperisakset.Pelaaja;
import main.java.kivipaperisakset.Peli;
import main.java.kivipaperisakset.Tuomari;
import main.java.kivipaperisakset.Vakiot;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class PeliTest {
    @Test
    public void testPelaa() {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();
        Peli peli = new Peli(pelaaja1, pelaaja2);

        assertFalse(peli.tuomari.peliLoppuu()); // Peli ei ole vielä alkanut, joten ei pitäisi olla päättynyt

        // Simuloidaan peliä ja varmistetaan, että se päättyy kolmella pelaajan 1 voitolla
        for (int i = 0; i < 3; i++) {
            pelaaja1.setVoitot();
            peli.pelaa();
        }

        assertTrue(peli.tuomari.peliLoppuu()); // Pelin pitäisi päättyä kolmella pelaajan 1 voitolla
    }
    @Test
    public void testTulostaPelinKulku() {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();
        Peli peli = new Peli(pelaaja1, pelaaja2);

        // Simuloidaan yhtä pelikierrosta
        String p1Valinta = Vakiot.KIVI;
        String p2Valinta = Vakiot.SAKSET;


        String expectedOutput = "Erä: 1 =====================\n" +
                "Tasapelien lukumäärä: 0\n" +
                "Pelaaja 1: " + p1Valinta
                + "\n\t Pelaaja 1:llä koossa 0 voittoa. \n"+
                "Pelaaja 2: " + p2Valinta
                + "\n\t Pelaaja 2:lla koossa 0 voittoa. \n" +
                "\n\t\t Pelaaja 1 voittaa \n";

        assertEquals(expectedOutput, peli.tulostaPelinKulku(1, p1Valinta, p2Valinta));
    }
}
