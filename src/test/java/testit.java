import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JFrame;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import nakymat.aloitysnaytto.Aloitusnaytto;
import nakymat.asetakayttajatiedot.AsetaKayttajaTiedot;
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
}