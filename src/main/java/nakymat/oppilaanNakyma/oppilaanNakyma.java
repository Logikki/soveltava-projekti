package nakymat.oppilaanNakyma;
import kayttajat.opiskelija.Opiskelija;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;    

public class oppilaanNakyma {
    protected Opiskelija kayttaja;
	JFrame ruutu;
	JLabel tervetuloa,header;
	public oppilaanNakyma(Opiskelija kayttaja) {
		this.kayttaja = kayttaja;
		DefaultListModel<String> suoritukset = new DefaultListModel<>();  
		HashMap<String,String> kurssit = kayttaja.getKurssiSuoritukset();
		ruutu = new JFrame();
		tervetuloa = new JLabel("Tervetuloa " + kayttaja.getNimi());
		ruutu.add(tervetuloa);
		tervetuloa.setBounds(80, -10, 150, 50);
		header = new JLabel("Arvosana     Kurssin nimi");
		header.setBounds(60, 10, 250, 50);
		ruutu.add(header);
		for (String kurssi : kurssit.keySet()) {
			suoritukset.addElement(kurssit.get(kurssi) + "     " + kurssi );
		}
		JList<String> list = new JList<>(suoritukset);
		list.setBounds(60,50, 200,200);  
		ruutu.add(list);    
		ruutu.setSize(400,400); ruutu.setVisible(true); ruutu.setLayout(null);
		

}
	}
    
