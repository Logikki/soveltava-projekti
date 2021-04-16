import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import kayttajat.henkilo.Henkilo;

class  henkiloTest {

    @Test
    void HenkiloTest() {
        Henkilo matti = new Henkilo("matti", "salasana", "matti@luukku.fi");
        assertTrue(matti.getSposti().equals("matti@luukku.fi"));
        assertTrue(matti.onkoSalasana("salasana"));
        assertTrue(matti.getNimi().equals("matti"));
    }
    @Test
    void setNimiTest() {
        Henkilo matti = new Henkilo("matti", "salasana", "matti@luukku.fi");
        matti.setNimi("Petteri");
        assertTrue(matti.getNimi().equals("Petteri"));
    }
    @Test
    void setSalasanaTest() {
        Henkilo matti = new Henkilo("matti", "salasana", "matti@luukku.fi");
        matti.setSalasana("salainenSalasana");
        assertTrue(matti.onkoSalasana("salainenSalasana"));
    }

}