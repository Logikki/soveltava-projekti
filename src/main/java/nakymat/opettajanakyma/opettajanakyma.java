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
        JFrame ikkuna = new JFrame();
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        final JLabel label = new JLabel();
        label.setSize(500,100);
        JButton b=new JButton("Lisää kurssisuoritus");  
        b.setBounds(300,150,170,30);

        final DefaultListModel<String> oppilaat = new DefaultListModel<>();
        ArrayList<Henkilo> oppilaatlist = new ArrayList<>();
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        henkilot = AsetaKayttajaTiedot.lataaKayttajat();
        
        for (Henkilo henkilo : henkilot) {
            if (henkilo.getClass() == Opiskelija.class) {
                oppilaat.addElement(henkilo.getNimi());
                oppilaatlist.add(henkilo);
            }
        }


        JList<String> lista = new JList<>(oppilaat);
        lista.setBounds(150,150, 100,100);
        ikkuna.add(lista); ikkuna.add(b); ikkuna.add(label);
        ikkuna.setSize(600,600);
        ikkuna.setLayout(null);
        ikkuna.setVisible(true);

        System.out.println("Opettajanäkymä luotu");

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (lista.getSelectedIndex() != -1) {                       
                    data = "Lisätään kurssisuoritus opiskelijalle " + lista.getSelectedValue();   
                    label.setText(data);

                    for (Henkilo hlo : oppilaatlist) {
                        if (hlo.getNimi().equals(lista.getSelectedValue())) {
                            Opiskelija o = (Opiskelija) hlo;

                            JFrame ik;
                            ik = new JFrame();
                            String knimi = JOptionPane.showInputDialog(ik,"Anna kurssin nimi");
                            String asana = JOptionPane.showInputDialog(ik,"Anna oppilaan arvosana");

                            o.lisaaKurssiSuoritus(knimi, asana);

                            System.out.println("Kurssisuoritus lisätty opiskelijalle!");
                            }
                        }

                }
            }  
        });
    }
}