package nakymat.opettajanakyma;
import javax.swing.*;
import nakymat.asetakayttajatiedot.AsetaKayttajaTiedot;
import java.awt.event.*; 
import java.util.ArrayList;
import kayttajat.opiskelija.Opiskelija;
import kayttajat.opettaja.Opettaja;
import kayttajat.henkilo.Henkilo;

public class Opettajanakyma {
    
    public Opettajanakyma() {
        JFrame ruutu = new JFrame();
        DefaultListModel<String> oppilaat = new DefaultListModel<>();
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        henkilot = AsetaKayttajaTiedot.lataaKayttajat();
        
        for (Henkilo henkilo : henkilot) {
            if (henkilo.getClass() == Opiskelija.class) {
                oppilaat.addElement(henkilo.getNimi());
            }
        }


        JList<String> lista = new JList<>(oppilaat);
        lista.setBounds(100,100, 75,75);
        ruutu.add(lista);
        ruutu.setSize(400,400);
        ruutu.setLayout(null);
        ruutu.setVisible(true);

>>>>>>> 227acc53238f0fc289b272bcf7b5cd5b530aaf9d
    }
}