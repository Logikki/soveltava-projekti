import javax.swing.*;  
import java.awt.event.*;  

public class Aloitusnaytto implements ActionListener {
    JButton UusiKayttaja, VanhaKayttaja;

    public Aloitusnaytto() {
        JFrame ruutu= new JFrame();
        UusiKayttaja = new JButton("Uusi käyttajä");
        VanhaKayttaja = new JButton("Vanha käyttäjä");
        UusiKayttaja.setBounds(50,50,200,50);
        VanhaKayttaja.setBounds(50,150,200,50);
        ruutu.add(VanhaKayttaja); 
        ruutu.add(UusiKayttaja);
        ruutu.setSize(300,300);  
        ruutu.setLayout(null);  
        ruutu.setVisible(true);  
        }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == UusiKayttaja) {
            //Suoritetaan rekisteröitymisvaihe
        }
        else if (e.getSource() == VanhaKayttaja) {
            //Suoritetaan kirjautuminen
        }
	}
    
}