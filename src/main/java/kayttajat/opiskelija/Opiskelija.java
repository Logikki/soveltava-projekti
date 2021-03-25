package kayttajat.opiskelija;
import java.util.HashMap;

public class Opiskelija implements java.io.Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 7481355780935856129L;
	protected String nimi;
    protected String opNumero;
    protected String salasana;
    protected HashMap<String, Integer> kurssiSuoritukset;

    public Opiskelija(String nimi, String opNumero, String salasana) {
		this.nimi = nimi;
		this.opNumero = opNumero;
		this.salasana = salasana;
		kurssiSuoritukset = new HashMap<>();
	}
    
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getOpNumero() {
		return opNumero;
	}
	public void setOpNumero(String opNumero) {
		this.opNumero = opNumero;
	}
	public String getSalasana() {
		return salasana;
	}
	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	public HashMap<String, Integer> getKurssiSuoritukset() {
		return kurssiSuoritukset;
	}
	public void lisaaKurssiSuoritus(String kurssi, Integer arvosana) {
		this.kurssiSuoritukset.put(kurssi, arvosana);
	}
}
