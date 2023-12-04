package main.java.kivipaperisakset;
/**
 * Luokka toimii tuomarina kivi-paperi-sakset -pelissä.
 * Tuomari tarkistaa yksittäisen kierroksen voittajan ja lopuksi tarkistaa, onko jo koko pelin voittajaa.
 */
public class Tuomari {
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private int tasapelit = 0;
    private boolean peliLoppuu = false;

    /**
     * Tuomari-luokan konstruktori.
     *
     * @param pelaaja1 Ensimmäinen pelaaja.
     * @param pelaaja2 Toinen pelaaja.
     */
    public Tuomari(Pelaaja pelaaja1, Pelaaja pelaaja2 ) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }

    /**
     * Tarkistaa yksittäisen kierroksen voittajan. Lopuksi tarkistaa, onko jo koko pelin voittajaa.
     *
     * @param p1Valinta Pelaajan 1 valinta (kivi, paperi tai sakset).
     * @param p2Valinta Pelaajan 2 valinta (kivi, paperi tai sakset).
     * @return Teksti, joka kuvaa kierroksen tuloksen (kumpi pelaajista voittaa).
     */
    public String tarkistaTulos(String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            tasapelit++;
            return Vakiot.TASAPELITEKSTI;
        }

        boolean pelaaja1Voittaa = (p1Valinta.equals(Vakiot.KIVI) && p2Valinta.equals(Vakiot.SAKSET)) ||
                (p1Valinta.equals(Vakiot.PAPERI) && p2Valinta.equals(Vakiot.KIVI)) ||
                (p1Valinta.equals(Vakiot.SAKSET) && p2Valinta.equals(Vakiot.PAPERI));

        if (pelaaja1Voittaa) {
            pelaaja1.setVoitot();
            return Vakiot.P1_VOITTOTEKSTI;
        } else {
            pelaaja2.setVoitot();
            return Vakiot.P2_VOITTOTEKSTI;
        }
    }


    /**
     * Palauttaa tasapelien lukumäärän.
     *
     * @return Tasapelien lukumäärä.
     */
    public int getTasapelit() {
        return tasapelit;
    }
    /**
     * Tarkistaa, onko peli päättynyt (jompikumpi pelaaja on saavuttanut kolme voittoa).
     *
     * @return true, jos peli on päättynyt, muuten false.
     */
    public boolean peliLoppuu () {
        if ((pelaaja1.getVoitot() >= 3) || (pelaaja2.getVoitot() >= 3)) {
            peliLoppuu = true;
        }
        return peliLoppuu;
    }
}
