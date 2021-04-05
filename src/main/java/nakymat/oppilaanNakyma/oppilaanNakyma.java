package nakymat.oppilaanNakyma;
import kayttajat.opiskelija.Opiskelija;
import javax.swing.*;
import java.awt.event.*;    

public class oppilaanNakyma {
    protected Opiskelija kayttaja;
	JFrame ruutu;
	JLabel tervetuloa;
	
	public oppilaanNakyma(Opiskelija kayttaja) {
		this.kayttaja = kayttaja;
        System.out.println("Opiskelijanakyma luotu");
		ruutu = new JFrame();
		ruutu.setSize(400,400); ruutu.setVisible(true); ruutu.setLayout(null);

	}
    
}