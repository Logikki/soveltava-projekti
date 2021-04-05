import nakymat.aloitysnaytto.Aloitusnaytto;
import nakymat.opettajanakyma.Opettajanakyma;
import nakymat.oppilaanNakyma.oppilaanNakyma;
import kayttajat.opiskelija.Opiskelija;

public class MainSuoritus {
    public static void main(String[] args) {
        Opiskelija matti = new Opiskelija("Matti", "salasana", "1234", "mattimeikalainen@gmail.com");
        matti.lisaaKurssiSuoritus("tkt123", "5");
        matti.lisaaKurssiSuoritus("ohjelmointi1", "5");
        matti.lisaaKurssiSuoritus("ohjelmointi2", "5");
        matti.lisaaKurssiSuoritus("psykologia1", "2");
        matti.lisaaKurssiSuoritus("kauppis2", "5"); 
        new oppilaanNakyma(matti);
     }
    }
