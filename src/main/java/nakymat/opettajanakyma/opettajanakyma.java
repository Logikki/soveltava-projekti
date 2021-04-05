package nakymat.opettajanakyma;
import javax.swing.*;
import nakymat.asetakayttajatiedot.AsetaKayttajaTiedot;
import java.awt.event.*; 
import java.util.ArrayList;
import kayttajat.opiskelija.Opiskelija;
import kayttajat.opettaja.Opettaja;
import kayttajat.henkilo.Henkilo;

public class Opettajanakyma implements ActionListener {
    
    public Opettajanakyma() {
        JFrame ikkuna = new JFrame();
        final JLabel label = new JLabel();
        label.setSize(500,100);
        JButton b=new JButton("Lisää kurssisuoritus");  
        b.setBounds(300,150,170,30);

        final DefaultListModel<String> oppilaat = new DefaultListModel<>();
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        henkilot = AsetaKayttajaTiedot.lataaKayttajat();
        
        for (Henkilo henkilo : henkilot) {
            if (henkilo.getClass() == Opiskelija.class) {
                oppilaat.addElement(henkilo.getNimi());
            }
        }


        JList<String> lista = new JList<>(oppilaat);
        lista.setBounds(150,150, 100,100);
        ikkuna.add(lista); ikkuna.add(b); ikkuna.add(label);
        ikkuna.setSize(600,600);
        ikkuna.setLayout(null);
        ikkuna.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (lista.getSelectedIndex() != -1) {                       
                    data = "Lisätään kurssisuoritus opiskelijalle:" + lista.getSelectedValue();   
                    label.setText(data);
            }
        }  
    });
    }

}