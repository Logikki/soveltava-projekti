package nakymat;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import kayttajat.*;

class AsetaKayttajatiedot implements ActionListerner {
    JButton valmis;
    JRadioButton opettajaRB,opiskelijaRB;
    JTextField Nimi;
    JPasswordField salasanaKentta;

    public AsetaKayttajatiedot() {
    JFrame ruutu= new JFrame();
    opiskelijaRB = new JRadioButton("Opiskelija");
    opettajaRB = new JRadioButton("Opettaja");
    opiskelijaRB.setBounds(100,50,100,30);    
    opettajaRB.setBounds(100,100,100,30);
    ButtonGroup bg=new ButtonGroup();    
    bg.add(opettajaRB); bg.add(opettajaRB);
    valmis = new JButton("Valmis");
    valmis.setBounds(100,150,80,30);   
    salasanaKentta = new JPasswordField();    
    salasanaKentta.setBounds(100,75,100,30);   
    ruutu.add(opiskelijaRB); ruutu.add(opettajaRB); ruutu.add(valmis); ruutu.add(salasanaKentta);
    ruutu.setSize(400,400);
    ruutu.setVisible(true); ruutu.setLayout(null);
    }
    public void actionPerformed(ActionEvent e){  }
}
}
}