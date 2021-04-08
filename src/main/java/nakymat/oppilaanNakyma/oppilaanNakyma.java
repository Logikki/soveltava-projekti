package nakymat.oppilaanNakyma;
import kayttajat.opiskelija.Opiskelija;
import nakymat.aloitysnaytto.Aloitusnaytto;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;    

public class oppilaanNakyma implements ActionListener {
    protected Opiskelija kayttaja;
	JFrame ruutu;
	JLabel tervetuloa,header;
	JMenu asetukset;
	JMenuItem kirjauduUlos, exit;
	JMenuBar palkki;
	public oppilaanNakyma(Opiskelija kayttaja) {
		this.kayttaja = kayttaja;
		ruutu = new JFrame();
		//yläpalkki
		palkki = new JMenuBar();
		asetukset = new JMenu("Asetukset");
		exit = new JMenuItem("Poistu");
		kirjauduUlos = new JMenuItem("Kirjaudu ulos");
		asetukset.add(kirjauduUlos);
		asetukset.add(exit);
		palkki.add(asetukset);
		kirjauduUlos.addActionListener(this);
		//Labelit
		tervetuloa = new JLabel("Tervetuloa " + kayttaja.getNimi());
		tervetuloa.setBounds(130, -10, 150, 50);
		header = new JLabel("Suoritetut kurssit: ");
		header.setBounds(130, 10, 250, 50);
		//lista suorituksista
		DefaultListModel<String> suoritukset = new DefaultListModel<>();  
		HashMap<String,String> kurssit = kayttaja.getKurssiSuoritukset();	
		suoritukset.addElement("Arvosana" + "     " + "Kurssin nimi" );
		for (String kurssi : kurssit.keySet()) {
			suoritukset.addElement(kurssit.get(kurssi) + "                " + kurssi );
		}
		JList<String> list = new JList<>(suoritukset);
		list.setBounds(100,50, 200,200); 
		//Alustetaan ruutu 
		ruutu.add(list); ruutu.add(header); ruutu.add(tervetuloa); ruutu.setJMenuBar(palkki);
		ruutu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ruutu.setSize(400,400); ruutu.setLayout(null); ruutu.setVisible(true); 
		

}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit ) {
			ruutu.dispatchEvent(new WindowEvent(ruutu, WindowEvent.WINDOW_CLOSING));
		}
		else if (e.getSource() == kirjauduUlos) {
			ruutu.dispose();
			new Aloitusnaytto();
		}
		
	}
	}
    
