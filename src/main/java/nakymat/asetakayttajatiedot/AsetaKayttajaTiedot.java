package nakymat.asetakayttajatiedot;
import javax.swing.*;
import java.awt.event.*;    
import kayttajat.opiskelija.Opiskelija;
import kayttajat.opettaja.Opettaja;
import kayttajat.henkilo.Henkilo;
import java.io.*;
import java.util.ArrayList;

public class AsetaKayttajaTiedot implements ActionListener {
    JButton valmis;
    JRadioButton opettajaRB,opiskelijaRB;
    JTextField Nimi, sposti, opNumero;
    JPasswordField salasanaKentta;
    JFrame ruutu;
    boolean OnkoUusiKayttaja;
    
    public AsetaKayttajaTiedot(boolean OnkoUusiKayttaja) {
        this.OnkoUusiKayttaja = OnkoUusiKayttaja;
        ruutu= new JFrame();
        ruutu.setSize(400,400);
        ruutu.setVisible(true); ruutu.setLayout(null);
        opiskelijaRB = new JRadioButton("Opiskelija");
        opettajaRB = new JRadioButton("Opettaja");
        opiskelijaRB.setBounds(100,120,100,30);    
        opettajaRB.setBounds(100,140,100,30);
        opiskelijaRB.setEnabled(true);
        ButtonGroup bg=new ButtonGroup();
        bg.add(opettajaRB); bg.add(opiskelijaRB);
        valmis = new JButton("Valmis");
        valmis.setBounds(220,120,80,30);
        valmis.addActionListener(this);   
        Nimi = new JTextField("nimi");
        Nimi.setBounds(100, 50, 200, 40);
        salasanaKentta = new JPasswordField();    
        salasanaKentta.setBounds(100,90,200,40);   
        ruutu.add(opiskelijaRB); ruutu.add(opettajaRB); ruutu.add(valmis); 
        ruutu.add(salasanaKentta); ruutu.add(Nimi);

        if (OnkoUusiKayttaja) {
            opiskelijaRB.addActionListener(this);
            opiskelijaRB.addActionListener(this);
            opNumero = new JTextField("Opiskelijanumero");
            opNumero.setBounds(100,10,200,40);
            ruutu.add(opNumero);
            sposti = new JTextField("Sähköposti");
            sposti.setBounds(100,90,200,40);
            salasanaKentta.setBounds(100,130,200,40);   
            ruutu.add(sposti);
            opiskelijaRB.setBounds(100,160,100,30);    
            opettajaRB.setBounds(100,180,100,30);
            valmis.setBounds(220,160,80,30);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){  
        if (e.getSource() == opettajaRB) { //tämä ei toimi
            ruutu.remove(opNumero);
        }
        else if (e.getSource() == opiskelijaRB) {
            ruutu.add(opNumero);
        }
        else if (e.getSource() == valmis) {
            String salasana = new String(this.salasanaKentta.getPassword());
            if (OnkoUusiKayttaja) { //tallennetaan uusi käyttäjä
                if (opiskelijaRB.isSelected()) {
                   tallennaKayttaja(new Opiskelija(this.Nimi.getText(), salasana, opNumero.getText(), sposti.getText())); 

                }
                else {
                   tallennaKayttaja(new Opettaja(this.Nimi.getText(), salasana, this.sposti.getText()));
                }
            }
        }
}
//Ensin otetaan tiedostosta mahdolliset valmiit käyttäjät listaan, sitten lisätään 
//uusi käyttäjä tähän listaan ja tallennetaan tiedostoon
    public static void tallennaKayttaja(Henkilo henkilo) {
            try {
               ArrayList<Henkilo> kayttajat = lataaKayttajat();
                kayttajat.add(henkilo);
                FileOutputStream WD = new FileOutputStream("kayttajat.ser");
                ObjectOutputStream kirjoitaTiedostoon = new ObjectOutputStream(WD);
                kirjoitaTiedostoon.writeObject(kayttajat);
                kirjoitaTiedostoon.flush();
                kirjoitaTiedostoon.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ei tallennettu");
        }

        }

        @SuppressWarnings("unchecked")
        public static ArrayList<Henkilo> lataaKayttajat() {
            ArrayList<Henkilo> kayttajat = new ArrayList<>();
            try {
                FileInputStream readData = new FileInputStream("kayttajat.ser");
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