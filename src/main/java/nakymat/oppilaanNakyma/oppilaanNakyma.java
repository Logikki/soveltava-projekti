package nakymat.oppilaanNakyma;
import kayttajat.opiskelija.Opiskelija;
import nakymat.aloitysnaytto.Aloitusnaytto;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;    

public class oppilaanNakyma implements ActionListener {
    protected Opiskelija kayttaja;
	JFrame ruutu;
	JLabel tervetuloa,header, ka, kurssejaSuoritettu;
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
		ka = new JLabel();
		kurssejaSuoritettu = new JLabel();
		kurssejaSuoritettu.setBounds(100,270,200,50);
		ka.setBounds(100, 250, 200, 50);
		tervetuloa = new JLabel(kayttaja.getNimi() + ", " + kayttaja.getOpNumero());
		tervetuloa.setBounds(10, -10, 300, 50);
		header = new JLabel("Suoritetut kurssit: ");
		header.setBounds(100, 10, 250, 50);
		//Tehdään suorituslista
		DefaultListModel<String> suoritukset = new DefaultListModel<>();  
		HashMap<String,String> kurssit = kayttaja.getKurssiSuoritukset();	
		suoritukset.addElement("Arvosana" + "     " + "Kurssin nimi" );
		for (String kurssi : kurssit.keySet()) {
			suoritukset.addElement(kurssit.get(kurssi) + "                " + kurssi );
		}
		JList<String> list = new JList<>(suoritukset);
		list.setBounds(100,50, 200,200); 
		ka.setText("Keskiarvo: " + kayttaja.annaKeskiarvo());
		kurssejaSuoritettu.setText("Kursseja suoritettu: " + kurssit.size());
		//Alustetaan ruutu 
		ruutu.add(list); ruutu.add(header); ruutu.add(tervetuloa); ruutu.setJMenuBar(palkki); 
		ruutu.add(ka); ruutu.add(kurssejaSuoritettu);
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
    
