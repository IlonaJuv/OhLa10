package main.java.kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
/**
 * Luokka edustaa kivi-paperi-sakset -peliä, jossa kaksi pelaajaa (Pelaaja-luokkaa) kilpailevat.
 * Peli käyttää myös Tuomari-luokkaa voittajan tarkistamiseen.
 */
public class Peli {
    Pelaaja p1;
    Pelaaja p2;
    public Tuomari tuomari;

    /**
     * Peli-luokan konstruktori.
     *
     * @param p1 Ensimmäinen pelaaja.
     * @param p2 Toinen pelaaja.
     */
    public Peli(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.tuomari = new Tuomari(this.p1, this.p2);
    }

    /**
     * Metodi käynnistää pelin ja ohjaa pelin kulkua, kunnes jompikumpi pelaaja saavuttaa kolme voittoa.
     */
    public void pelaa() {
        int pelatutPelit = 1;           // Pelattujen pelien lkm
        String p1Valinta;
        String p2Valinta;

        do {
            p1Valinta = p1.pelaajanValinta();
            p2Valinta = p2.pelaajanValinta();

            System.out.println(tulostaPelinKulku(pelatutPelit, p1Valinta, p2Valinta));
            pelatutPelit++;
            System.out.println();
        } while (!tuomari.peliLoppuu());

        System.out.println(String.format("KOLME VOITTOA - PELI PÄÄTTYY%n\t Pelaaja 1:llä %d voittoa ja " +
                "pelaaja 2:lla %d voittoa", p1.getVoitot(), p2.getVoitot()));
    }

    /**
     * Tulostaa pelin kulun yhteenvedon.
     *
     * @param pelatutPelit Pelattujen pelien lukumäärä.
     * @param p1Valinta Pelaajan 1 valinta (kivi, paperi tai sakset).
     * @param p2Valinta Pelaajan 2 valinta (kivi, paperi tai sakset).
     * @return Merkkijono, joka kuvaa pelin kulun yhteenvedon.
     */
    public String tulostaPelinKulku(int pelatutPelit, String p1Valinta, String p2Valinta) {
        String pelinkulku = ("Erä: "
                + pelatutPelit + " =====================\n" +
                "Tasapelien lukumäärä: "
                + tuomari.getTasapelit() + "\n" +
                "Pelaaja 1: " + p1Valinta
                + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa. \n"+
                "Pelaaja 2: " + p2Valinta
                + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa. \n" +
                tuomari.tarkistaTulos(p1Valinta, p2Valinta));
        return pelinkulku;
    }
}
