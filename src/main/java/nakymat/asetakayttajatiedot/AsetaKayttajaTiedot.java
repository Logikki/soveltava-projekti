package nakymat.asetakayttajatiedot;
import javax.swing.*;
import java.awt.event.*;    
import kayttajat.opiskelija.Opiskelija;
import kayttajat.opettaja.Opettaja;

public class AsetaKayttajaTiedot implements ActionListener {
    JButton valmis;
    JRadioButton opettajaRB,opiskelijaRB;
    JTextField Nimi, tietoKentta;
    JPasswordField salasanaKentta;
    JFrame ruutu;
    
    public AsetaKayttajaTiedot(boolean OnkoUusiKayttaja) {
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
            tietoKentta = new JTextField("Opiskelija numero");
            tietoKentta.setBounds(100,90,200,40);
            salasanaKentta.setBounds(100,130,200,40);   
            ruutu.add(tietoKentta);
            opiskelijaRB.setBounds(100,160,100,30);    
            opettajaRB.setBounds(100,180,100,30);
            valmis.setBounds(220,160,80,30);
            if (opettajaRB.isSelected()) {
                tietoKentta.setText("Sähköposti");
            }
            else {
                tietoKentta.setText("Opiskelija numero");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){  
        String salasana = new String(this.salasanaKentta.getPassword());
        if (opiskelijaRB.isSelected()) {
            new Opiskelija(this.Nimi.getText(), this.tietoKentta.getText(), salasana);
        }
        else {
            new Opettaja(this.Nimi.getText(), salasana, this.tietoKentta.getText());
        }
    }
}