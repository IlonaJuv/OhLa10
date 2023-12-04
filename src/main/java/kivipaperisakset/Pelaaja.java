
package main.java.kivipaperisakset;
/**
 * Luokka edustaa pelaajaa kivi-paperi-sakset -pelissä.
 * Pelaajalla on voittojen lukumäärä sekä metodi pelaajanValinta, joka valitsee randomilla kivi, paperin tai sakset.
 */
public class Pelaaja {

    int voitot;      // Voittojen lukumäärä

    /**
     * Valitsee randomilla kivi, paperi tai sakset.
     *
     * @return Pelaajan valinta (kivi, paperi tai sakset)
     */
    public String pelaajanValinta() {
        String valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = (Vakiot.KIVI);
                break;
            case 1:
                valinta = (Vakiot.PAPERI);
                break;
            case 2:
                valinta = (Vakiot.SAKSET);
                break;
        }
        return valinta;
    }

    /**
     * Kasvattaa voittojen lukumäärää yhdellä.
     */
    public void setVoitot() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen lukumäärän.
     *
     * @return Pelaajan voittojen lukumäärä.
     */
    public int getVoitot() {
        return voitot;
    }
}
