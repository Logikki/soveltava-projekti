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
        valmis.setBounds(220,180,80,30);
        valmis.addActionListener(this);

        JLabel spostiLabel = new JLabel("Sähköposti:");
        spostiLabel.setBounds(10, 50, 200, 40);
        ruutu.add(spostiLabel);
        sahkoPostiKentta = new JTextField("");
        sahkoPostiKentta.setBounds(100, 50, 200, 40);

        JLabel salasanaLabel = new JLabel("Salasana:");
        salasanaLabel.setBounds(23, 90, 200, 40);
        ruutu.add(salasanaLabel);
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
            opettajaRB.addActionListener(this);

            JLabel opNumeroLabel = new JLabel("Op.numero:");
            opNumeroLabel.setBounds(10, 10, 200, 40);
            ruutu.add(opNumeroLabel);
            opNumero = new JTextField("");
            opNumero.setBounds(100,10,200,40);
            ruutu.add(opNumero);

            JLabel nimiKenttäLabel = new JLabel("Nimi:");
            nimiKenttäLabel.setBounds(48, 90, 200, 40);
            ruutu.add(nimiKenttäLabel);
            nimiKentta = new JTextField("");
            nimiKentta.setBounds(100,90,200,40);
            ruutu.add(nimiKentta);

            salasanaLabel.setBounds(23, 130, 200, 40);
            salasanaKentta.setBounds(100,130,200,40);
            opiskelijaRB.setBounds(100,180,100,30);    
            opettajaRB.setBounds(100,210,100,30);
            valmis.setBounds(220,180,80,30);
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
                if (opiskelijaRB.isSelected()) { //Luodaan uusi opiskelija käyttäjä
                   tallennaKayttaja(new Opiskelija(nimiKentta.getText(), salasana, opNumero.getText(), this.sahkoPostiKentta.getText()));
                   new Aloitusnaytto();

                }
                else { //luodaan uusi opettaja käyttäjä
                   tallennaKayttaja(new Opettaja(this.nimiKentta.getText(), salasana, this.sahkoPostiKentta.getText()));
                   new Aloitusnaytto();
                }
                ruutu.dispose(); 
                JFrame f = new JFrame();  
                JOptionPane.showMessageDialog(f,"Käyttäjä luotu!");  
            }
            else { //Katsotaan onko käyttäjäsahkoPostiKentta ja salasana oikein 
                ArrayList<Henkilo> kayttajat = lataaKayttajat();
                for (Henkilo kayttaja : kayttajat) { //käydään läpi käyttäjät
                    if (kayttaja.getSposti().equals(sahkoPostiKentta.getText()) 
                    && kayttaja.getSalasana().equals(salasana)) {
                        Henkilo kirjautuva = kayttaja;
                        if (kirjautuva.getClass() == Opettaja.class) {
                            Opettaja kayttajaOpettaja = (Opettaja)kayttaja;
                            new Opettajanakyma(kayttajaOpettaja);
                        }
                        else {
                            Opiskelija kayttajaOpiskelija = (Opiskelija)kayttaja;
                            new oppilaanNakyma(kayttajaOpiskelija);
                        }
                        ruutu.dispose(); return;
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