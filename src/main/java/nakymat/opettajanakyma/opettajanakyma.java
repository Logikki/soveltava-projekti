package nakymat.opettajanakyma;
import javax.swing.*;

import nakymat.aloitysnaytto.Aloitusnaytto;
import nakymat.asetakayttajatiedot.AsetaKayttajaTiedot;
import java.awt.event.*; 
import java.util.ArrayList;
import kayttajat.opettaja.*;
import kayttajat.opiskelija.Opiskelija;
import kayttajat.henkilo.Henkilo;
import java.io.*;
import java.util.HashMap;

public class Opettajanakyma implements ActionListener {
    protected Opettaja ope;
    JFrame ikkuna;
    JLabel tervetuloa;
    JMenu asetukset;
    JMenuItem kirjauduUlos, exit;
    JMenuBar palkki;
    JButton b, n;

    public Opettajanakyma(Opettaja ope) {
        this.ope = ope;
        ikkuna = new JFrame();

        //yläpalkki
        palkki = new JMenuBar();
        asetukset = new JMenu("Asetukset");
        exit = new JMenuItem("Poistu");
        kirjauduUlos = new JMenuItem("Kirjaudu ulos");
        asetukset.add(kirjauduUlos);
        asetukset.add(exit);
        palkki.add(asetukset);
        kirjauduUlos.addActionListener(this);
        tervetuloa = new JLabel(ope.getNimi());
		tervetuloa.setBounds(10, -10, 300, 50);


        //Listat oppilaille
        final DefaultListModel<String> oppilaat = new DefaultListModel<>();
        ArrayList<Henkilo> oppilaatlist = new ArrayList<>();
        ArrayList<Henkilo> henkilot = new ArrayList<>(AsetaKayttajaTiedot.lataaKayttajat());
        
        for (Henkilo henkilo : henkilot) {
            if (henkilo.getClass() == Opiskelija.class) {
                oppilaat.addElement(henkilo.getNimi());
                oppilaatlist.add(henkilo);
            }
        }

        JList<String> lista = new JList<>(oppilaat);
        lista.setBounds(150,80, 100,300);

        //Nappi, josta opettaja voi lisätä kurssisuorituksen valitsemalleen oppilaalle
        b=new JButton("Lisää kurssisuoritus");  
        b.setBounds(300,150,170,30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (lista.getSelectedIndex() != -1) {                       
                    for (Henkilo hlo : henkilot) {
                        if (hlo.getNimi().equals(lista.getSelectedValue())) {
                            Opiskelija o = (Opiskelija) hlo;
                            henkilot.remove(hlo);
                            JFrame ik = new JFrame();
                            String knimi = JOptionPane.showInputDialog(ik,"Syötä kurssin tunnus");
                            String asana = JOptionPane.showInputDialog(ik,"Syötä oppilaan " + o.getNimi() + " kurssista saama arvosana");
        
                            if (knimi.length() > 0 && asana.length() > 0) {
                                o.lisaaKurssiSuoritus(knimi, asana);
                                henkilot.add(o);
                                yliKirjoitaTiedosto(henkilot);
                                System.out.println("Kurssisuoritus lisätty opiskelijalle!");
                            }
                        }
                    }
                }
            }
        });

        n = new JButton("Tarkastele suorituksia");
        n.setBounds(300,100,170,30);
        n.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Henkilo hlo : henkilot) {
                    if (hlo.getNimi().equals(lista.getSelectedValue())) {
                        Opiskelija o = (Opiskelija) hlo;

                        JFrame ik = new JFrame();
                        DefaultListModel<String> suoritukset = new DefaultListModel<>();  
		                HashMap<String,String> kurssit = o.getKurssiSuoritukset();	
		                suoritukset.addElement("Arvosana" + "                  " + "Kurssin tunnus" );
		                
                        for (String kurssi : kurssit.keySet()) {
			                suoritukset.addElement(kurssit.get(kurssi) + "                                  " + kurssi );
		                    }

		                JList<String> suor = new JList<>(suoritukset);
		                suor.setBounds(100,50, 200,300);

                        ik.add(suor);
                        ik.setSize(400, 600);
                        ik.setLayout(null);
                        ik.setVisible(true);
                }
            }
        }
        });

        ikkuna.add(lista); ikkuna.add(b); ikkuna.add(n); ikkuna.add(tervetuloa); ikkuna.setJMenuBar(palkki);
        ikkuna.setSize(600,600);
        ikkuna.setLayout(null);
        ikkuna.setVisible(true);
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            ikkuna.dispatchEvent(new WindowEvent(ikkuna, WindowEvent.WINDOW_CLOSING));
        }

        else if (e.getSource() == kirjauduUlos) {
            ikkuna.dispose();
            new Aloitusnaytto();
        }
    }


    public static void yliKirjoitaTiedosto(ArrayList<Henkilo> kayttajat) {
        try {
            FileOutputStream WD = new FileOutputStream("src/main/resources/kayttajat.ser");
            ObjectOutputStream kirjoitaTiedostoon = new ObjectOutputStream(WD);
            kirjoitaTiedostoon.writeObject(kayttajat);
            kirjoitaTiedostoon.flush();
            kirjoitaTiedostoon.close();
            System.out.println("Tallennettu" + kayttajat.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ei tallennettu");
        }

    }
}