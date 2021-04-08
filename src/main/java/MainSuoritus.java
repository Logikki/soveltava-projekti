import kayttajat.opiskelija.Opiskelija;
import nakymat.aloitysnaytto.Aloitusnaytto;
import nakymat.oppilaanNakyma.oppilaanNakyma;

public class MainSuoritus {
    public static void main(String[] args) {
        Opiskelija Matti = new Opiskelija("matti", "salasana", "123", "mattimeikalainne@moi.fi");
        Matti.lisaaKurssiSuoritus("historia", "5");
        Matti.lisaaKurssiSuoritus("ruotsi", "5");
        Matti.lisaaKurssiSuoritus("kemia", "5");
        Matti.lisaaKurssiSuoritus("fysiikka", "5");
        new oppilaanNakyma(Matti);
        }
}