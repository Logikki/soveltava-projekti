package nakymat.asetakayttajatiedot;
import javax.swing.*;
import java.awt.event.*;    


public class AsetaKayttajaTiedot implements ActionListener {
    JButton valmis;
    JRadioButton opettajaRB,opiskelijaRB;
    JTextField Nimi;
    JPasswordField salasanaKentta;
    JFrame ruutu;
    
    public AsetaKayttajaTiedot() {
        ruutu= new JFrame();
        ruutu.setSize(400,400);
        ruutu.setVisible(true); ruutu.setLayout(null);
        opiskelijaRB = new JRadioButton("Opiskelija");
        opettajaRB = new JRadioButton("Opettaja");
        opiskelijaRB.setBounds(80,180,100,30);    
        opettajaRB.setBounds(80,240,100,30);
        ButtonGroup bg=new ButtonGroup();
        bg.add(opettajaRB); bg.add(opiskelijaRB);
        valmis = new JButton("Valmis");
        valmis.setBounds(220,180,80,30);
        valmis.addActionListener(this);   
        Nimi = new JTextField("nimi");
        Nimi.setBounds(100, 75, 200, 40);
        salasanaKentta = new JPasswordField();    
        salasanaKentta.setBounds(100,150,200,40);   
        ruutu.add(opiskelijaRB); ruutu.add(opettajaRB); ruutu.add(valmis); 
        ruutu.add(salasanaKentta); ruutu.add(Nimi);
    }

    public AsetaKayttajaTiedot(boolean onkoUusiKayttaja) { //suoritetaan jos kirjaudutaan ensimmäistä kertaa
        new AsetaKayttajaTiedot();
    }
    @Override
    public void actionPerformed(ActionEvent e){  
        if (opiskelijaRB.isSelected() && opettajaRB.isSelected()) {
            JOptionPane.showMessageDialog(ruutu, "Valitse vaihtoehdoista toinen");
        }
    }
}