import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import kayttajat.henkilo.Henkilo;
import kayttajat.opiskelija.Opiskelija;

class  testit {
    @Test
    void HenkiloTest() {
        Henkilo matti = new Henkilo("matti", "salasana", "matti@luukku.fi");
        assertTrue(matti.getSposti().equals("matti@luukku.fi"));
        assertTrue(matti.getSalasana().equals("salasana"));
        assertTrue(matti.getNimi().equals("matti"));

    }
    @Test
    void annaKeskiarvoTest() {
        Opiskelija matti = new Opiskelija("matti", "salasana", "1234", "matti.opiskleija@gmail.com");
        matti.lisaaKurssiSuoritus("TKO12", "5");
        matti.lisaaKurssiSuoritus("TKO1234", "5");
        matti.lisaaKurssiSuoritus("TKO1234", "3");
        float ka = (5+5+3)/3;
        assertTrue(matti.annaKeskiarvo() == ka);
    }
}