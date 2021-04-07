package nakymat.asetakayttajatiedot;
import javax.swing.*;
import java.awt.event.*;    
import kayttajat.opiskelija.Opiskelija;
import kayttajat.opettaja.Opettaja;
import kayttajat.henkilo.Henkilo;
import java.io.*;
import java.util.ArrayList;
import nakymat.aloitysnaytto.Aloitusnaytto;
import nakymat.opettajanakyma.Opettajanakyma;
import nakymat.oppilaanNakyma.oppilaanNakyma;

public class AsetaKayttajaTiedot implements ActionListener {
    JButton valmis;
    JRadioButton opettajaRB,opiskelijaRB;
    JTextField sahkoPostiKentta, nimiKentta, opNumero;
    JPasswordField salasanaKentta;
    JFrame ruutu;
    boolean OnkoUusiKayttaja;
    JLabel vaaraTunnus;
    public AsetaKayttajaTiedot(boolean OnkoUusiKayttaja) {
        this.OnkoUusiKayttaja = OnkoUusiKayttaja;
        ruutu= new JFrame();
        ruutu.setLayout(null);
        valmis = new JButton("Valmis");
        valmis.setBounds(220,130,80,30);
        valmis.addActionListener(this);   
        sahkoPostiKentta = new JTextField("Sähköposti");
        sahkoPostiKentta.setBounds(100, 50, 200, 40);
        salasanaKentta = new JPasswordField();    
        salasanaKentta.setBounds(100,90,200,40);   
        ruutu.add(valmis); 
        ruutu.add(salasanaKentta); ruutu.add(sahkoPostiKentta);
        vaaraTunnus = new JLabel();
        vaaraTunnus.setBounds(80, 140, 250, 50);
        ruutu.add(vaaraTunnus);
        ruutu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        if (OnkoUusiKayttaja) {
            opiskelijaRB = new JRadioButton("Opiskelija");
            opettajaRB = new JRadioButton("Opettaja");
            ButtonGroup bg=new ButtonGroup();
            bg.add(opettajaRB); bg.add(opiskelijaRB);
            opiskelijaRB.addActionListener(this);
            opiskelijaRB.addActionListener(this);
            opNumero = new JTextField("Opiskelijanumero");
            opNumero.setBounds(100,10,200,40);
            ruutu.add(opNumero);
            nimiKentta = new JTextField("Nimi");
            nimiKentta.setBounds(100,90,200,40);
            salasanaKentta.setBounds(100,130,200,40);   
            ruutu.add(nimiKentta);
            opiskelijaRB.setBounds(100,160,100,30);    
            opettajaRB.setBounds(100,180,100,30);
            valmis.setBounds(220,160,80,30);
            ruutu.add(opiskelijaRB); ruutu.add(opettajaRB);
            opiskelijaRB.setEnabled(true);
        }
        ruutu.setSize(400,400);
        ruutu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){  
        if (e.getSource() == valmis) {
            String salasana = new String(this.salasanaKentta.getPassword());
            if (this.OnkoUusiKayttaja) { //tallennetaan uusi käyttäjä tässä tapauksessa
                if (opiskelijaRB.isSelected()) {
                   tallennaKayttaja(new Opiskelija(nimiKentta.getText(), salasana, opNumero.getText(), this.sahkoPostiKentta.getText()));
                   new Aloitusnaytto();

                }
                else {
                   tallennaKayttaja(new Opettaja(this.nimiKentta.getText(), salasana, this.sahkoPostiKentta.getText()));
                   new Aloitusnaytto();
                }
            }
            else { //Katsotaan onko käyttäjäsahkoPostiKentta ja salasana oikein 
                ArrayList<Henkilo> kayttajat = lataaKayttajat();
                for (Henkilo kayttaja : kayttajat) { //käydään läpi käyttäjät
                    if (kayttaja.getSposti().equals(sahkoPostiKentta.getText()) 
                    && kayttaja.getSalasana().equals(salasana)) {
                        Henkilo kirjautuva = kayttaja;
                        if (kirjautuva.getClass() == Opettaja.class) {
                            new Opettajanakyma();
                        }
                        else {
                            Opiskelija kayttajaOpiskelija = (Opiskelija)kayttaja;
                            new oppilaanNakyma(kayttajaOpiskelija);
                        }
                    }
                }
                vaaraTunnus.setText("Sähköposti ja salasana ei täsmää");
            }
        }
    }
//Ensin otetaan tiedostosta mahdolliset valmiit käyttäjät listaan, sitten lisätään 
//uusi käyttäjä tähän listaan ja tallennetaan tiedostoon
    public static void tallennaKayttaja(Henkilo henkilo) {
            try {
                ArrayList<Henkilo> kayttajat = lataaKayttajat();
                kayttajat.add(henkilo);
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
        //Tämä lataa tiedostosta käyttäjät listan ja palauttaa sen
        @SuppressWarnings("unchecked")
        public static ArrayList<Henkilo> lataaKayttajat() {
            ArrayList<Henkilo> kayttajat = new ArrayList<>();
            try {
                FileInputStream readData = new FileInputStream("src/main/resources/kayttajat.ser");
                ObjectInputStream readStream = new ObjectInputStream(readData);
                kayttajat = (ArrayList<Henkilo>) readStream.readObject();
                readStream.close();
                
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return kayttajat;
    }
}