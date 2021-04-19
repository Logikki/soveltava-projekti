package nakymat.aloitysnaytto;
import nakymat.asetakayttajatiedot.AsetaKayttajaTiedot;
import javax.swing.*;  
import java.awt.event.*;  

/** Aloitusnäyttö
 * Kysytään halutaanko kirjautua vai rekisteröityä
 * @author Roni
    */
 public class Aloitusnaytto implements ActionListener {
    JButton UusiKayttaja, VanhaKayttaja;
    JFrame ruutu;
    /** 
     * Alkunäytön konstruktori.
     * Näyttää napit "Uusi käyttäjä" ja "Vanha käyttäjä".
     * @since 1.0
     */
    public Aloitusnaytto() {
        ruutu= new JFrame();
        ruutu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        UusiKayttaja = new JButton("Uusi käyttajä");
        VanhaKayttaja = new JButton("Vanha käyttäjä");
        UusiKayttaja.setBounds(50,50,200,50);
        VanhaKayttaja.setBounds(50,150,200,50);
        ruutu.add(VanhaKayttaja); 
        ruutu.add(UusiKayttaja);
        ruutu.setSize(300,300);  
        ruutu.setLayout(null);  
        UusiKayttaja.addActionListener(this);
        VanhaKayttaja.addActionListener(this);
        ruutu.setVisible(true);  
        }

	
    /** {@inheritDoc}
     * Nappien toiminnallisuus. 
     * @return kirjautumis tai rekisteröitymisnäyttö.
     */
    @Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == UusiKayttaja) { //Suoritetaan rekisteröitymisvaihe
            ruutu.dispose();
            new AsetaKayttajaTiedot(true);
        }
        else { //kirjaudutaan sisään
            ruutu.dispose();
            new AsetaKayttajaTiedot(false);
        }
	}
}