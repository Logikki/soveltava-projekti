package nakymat.asetakayttajatiedot;
import javax.swing.*;
import java.awt.event.*;    


public class AsetaKayttajaTiedot implements ActionListener {
    JButton valmis;
    JRadioButton opettajaRB,opiskelijaRB;
    JTextField Nimi, OpNumero;
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
        ButtonGroup bg=new ButtonGroup();
        bg.add(opettajaRB); bg.add(opiskelijaRB);
        valmis = new JButton("Valmis");
        valmis.setBounds(220,180,80,30);
        valmis.addActionListener(this);   
        Nimi = new JTextField("nimi");
        Nimi.setBounds(100, 50, 200, 40);
        salasanaKentta = new JPasswordField();    
        salasanaKentta.setBounds(100,90,200,40);   
        ruutu.add(opiskelijaRB); ruutu.add(opettajaRB); ruutu.add(valmis); 
        ruutu.add(salasanaKentta); ruutu.add(Nimi);
        if (OnkoUusiKayttaja) {

            OpNumero = new JTextField("OpiskelijaNumero");
            OpNumero.setBounds(100,90,200,40);
            salasanaKentta.setBounds(100,130,200,40);   
            ruutu.add(OpNumero);
            opiskelijaRB.setBounds(100,160,100,30);    
            opettajaRB.setBounds(100,180,100,30);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){  
        if (opiskelijaRB.isSelected()) {
            
        }
    }
}