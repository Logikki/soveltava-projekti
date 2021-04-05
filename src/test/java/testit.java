import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import nakymat.aloitysnaytto.Aloitusnaytto;
import nakymat.asetakayttajatiedot.AsetaKayttajaTiedot;
import kayttajat.henkilo.Henkilo;
import kayttajat.opiskelija.Opiskelija;


class  testit {

    @Test

    void tallennusTest() {
        Henkilo opiskelija = new Henkilo("maija", "salasana", "maijameikalainen@moi.fi");
        AsetaKayttajaTiedot.tallennaKayttaja(opiskelija);
        assertTrue(AsetaKayttajaTiedot.lataaKayttajat().contains(opiskelija));
    }
}