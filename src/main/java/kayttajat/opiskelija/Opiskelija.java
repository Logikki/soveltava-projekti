package kayttajat.opiskelija;
import java.util.HashMap;
import kayttajat.henkilo.Henkilo;

public class Opiskelija extends Henkilo {
    /**
	 *
	 */
	private static final long serialVersionUID = 4329592575951960482L;
	protected String opNumero;
    protected HashMap<String, String> kurssiSuoritukset;

    public Opiskelija(String nimi, String salasana, String opNumero, String sposti) {
		super(nimi, salasana, sposti);
		this.opNumero = opNumero;
		kurssiSuoritukset = new HashMap<>();
	}
	public String getOpNumero() {
		return opNumero;
	}
	public void setOpNumero(String opNumero) {
		this.opNumero = opNumero;
	}
	public HashMap<String, String> getKurssiSuoritukset() {
		return kurssiSuoritukset;
	}
	public void lisaaKurssiSuoritus(String kurssi, String arvosana) {
		this.kurssiSuoritukset.put(kurssi, arvosana);
	}

	/** 
	 * Metodi opiskelijan kurssisuoritusten keskiarvon laskemiseen
	 * 
	 * @return Double-tyyppinen luku
	 */
	public double annaKeskiarvo() {
		double ka = 0;
		if (kurssiSuoritukset.size() != 0) {
			for (String asana : kurssiSuoritukset.keySet()) {
				try {
					ka += Integer.valueOf(kurssiSuoritukset.get(asana));
				}
				catch (NumberFormatException e) {
					continue;
			}
		}
			ka = ka/kurssiSuoritukset.size();
			return ka;
	
	}
	return 0.0;
}
	public int kurssejaSuoritettu() {
		int testi = 0;
		int suoritettu = 0;
		if (kurssiSuoritukset.size() != 0) {
			for (String asana : kurssiSuoritukset.keySet()) {
				try {
					testi = Integer.parseInt(kurssiSuoritukset.get(asana));
				}
				catch (NumberFormatException e) {
					suoritettu -= 1;
			}
			suoritettu += 1;
		}
			return suoritettu;
	
	}
	return 0;
	}

/** {@inheritDoc} 
 * 
 * @return siisti tulostus käyttäjästä
 */
	@Override
	public String toString() {
		return "Opiskelija" + super.toString() + "[kurssiSuoritukset=" + kurssiSuoritukset + ", opNumero=" + opNumero + "]";
	}
}
