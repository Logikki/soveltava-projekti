package nakymat;
import javax.swing.*;

import kayttajat.*;

class AsetaKayttajatiedot implements ActionListerner {
    JButton valmis;
    JRadioButton opettajaRB,opiskelijaRB;
    JTextField Nimi;
    
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
}
}