import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import kayttajat.opiskelija.Opiskelija;

class opiskelijaTest {
    @Test
    void kurssiTest() {
        Opiskelija matti = new Opiskelija("matti", "salasana", "1234", "matti.opiskleija@gmail.com");
        matti.lisaaKurssiSuoritus("TKO12", "5");
        matti.lisaaKurssiSuoritus("TKO1234", "5");
        matti.lisaaKurssiSuoritus("TKO12345", "3");
        assertTrue(matti.getKurssiSuoritukset().containsKey("TKO12"));
        assertTrue(matti.getKurssiSuoritukset().containsKey("TKO1234"));
        assertTrue(matti.getKurssiSuoritukset().containsKey("TKO12345"));
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