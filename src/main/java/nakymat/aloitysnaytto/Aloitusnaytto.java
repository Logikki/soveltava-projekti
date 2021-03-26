package nakymat.aloitysnaytto;
import nakymat.asetakayttajatiedot.AsetaKayttajaTiedot;
import javax.swing.*;  
import java.awt.event.*;  

 public class Aloitusnaytto implements ActionListener {
    JButton UusiKayttaja, VanhaKayttaja;
    JFrame ruutu;

    public Aloitusnaytto() {
        ruutu= new JFrame();
        UusiKayttaja = new JButton("Uusi käyttajä");
        VanhaKayttaja = new JButton("Vanha käyttäjä");
        UusiKayttaja.setBounds(50,50,200,50);
        VanhaKayttaja.setBounds(50,150,200,50);
        ruutu.add(VanhaKayttaja); 
        ruutu.add(UusiKayttaja);
        ruutu.setSize(300,300);  
        ruutu.setLayout(null);  
        ruutu.setVisible(true);  
        UusiKayttaja.addActionListener(this);
        VanhaKayttaja.addActionListener(this);
        }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == UusiKayttaja) { //Suoritetaan rekisteröitymisvaihe
            ruutu.setVisible(false);
            new AsetaKayttajaTiedot(true);
        }
        
        else { //kirjaudutaan sisään
            ruutu.setVisible(false);
            new AsetaKayttajaTiedot(false);
        }
	}
    
}